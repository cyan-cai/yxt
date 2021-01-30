package com.java.yxt.util;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * 
 * @Description 雪花算法（SnowFlake）Java实现 生成不重复的序列号
 * @author lfl
 * @date 2020年8月22日
 */
public class SequenceWorker{
	
	private static final Random RANDOM = new Random();

	/** 下面两个每个5位，加起来就是10位的工作机器id */
	/** 工作id */
    private long workerId;
    /** 数据id */
    private long datacenterId;
    /** 12位的序列号 */
    private long sequence;

    public SequenceWorker(long workerId, long datacenterId, long sequence){
        // sanity check for workerId
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0",maxWorkerId));
        }
        if (datacenterId > maxDatacenterId || datacenterId < 0) {
            throw new IllegalArgumentException(String.format("datacenter Id can't be greater than %d or less than 0",maxDatacenterId));
        }
//        System.out.printf("worker starting. timestamp left shift %d, datacenter id bits %d, worker id bits %d, sequence bits %d, workerid %d",
//                timestampLeftShift, datacenterIdBits, workerIdBits, sequenceBits, workerId);

        this.workerId = workerId;
        this.datacenterId = datacenterId;
        this.sequence = sequence;
    }

    /** 初始时间戳 */
    private long twepoch = 1288834974657L;

    /** 长度为5位 */
    private long workerIdBits = 5L;
    private long datacenterIdBits = 5L;
    /** 最大值 */
    private long maxWorkerId = -1L ^ (-1L << workerIdBits);
    private long maxDatacenterId = -1L ^ (-1L << datacenterIdBits);
    /** 序列号id长度 */
    private long sequenceBits = 12L;
    /** 序列号最大值 */
    private long sequenceMask = -1L ^ (-1L << sequenceBits);
    
    /** 工作id需要左移的位数，12位 */
    private long workerIdShift = sequenceBits;
    /** 数据id需要左移位数 12+5=17位 */
    private long datacenterIdShift = sequenceBits + workerIdBits;
    /** 时间戳需要左移位数 12+5+5=22位 */
    private long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;
    
    /** 上次时间戳，初始值为负数 */
    private long lastTimestamp = -1L;

    public long getWorkerId(){
        return workerId;
    }

    public long getDatacenterId(){
        return datacenterId;
    }

    public long getTimestamp(){
        return System.currentTimeMillis();
    }

    /**
     * 
     * @Title: nextId
     * @Description: 下一个ID生成算法
     * @param @return 参数
     * @return long 返回类型
     * @throws
     */
    public synchronized long nextId() {
        long timestamp = timeGen();

        //获取当前时间戳如果小于上次时间戳，则表示时间戳获取出现异常
        if (timestamp < lastTimestamp) {
            System.err.printf("clock is moving backwards.  Rejecting requests until %d.", lastTimestamp);
            throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds",
                    lastTimestamp - timestamp));
        }

        //获取当前时间戳如果等于上次时间戳（同一毫秒内），则在序列号加一；否则序列号赋值为0，从0开始。
        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0;
        }
        
        //将上次时间戳值刷新
        lastTimestamp = timestamp;

        /**
          * 返回结果：
          * (timestamp - twepoch) << timestampLeftShift) 表示将时间戳减去初始时间戳，再左移相应位数
          * (datacenterId << datacenterIdShift) 表示将数据id左移相应位数
          * (workerId << workerIdShift) 表示将工作id左移相应位数
          * | 是按位或运算符，例如：x | y，只有当x，y都为0的时候结果才为0，其它情况结果都为1。
          * 因为个部分只有相应位上的值有意义，其它位上都是0，所以将各部分的值进行 | 运算就能得到最终拼接好的id
        */
        return ((timestamp - twepoch) << timestampLeftShift) |
                (datacenterId << datacenterIdShift) |
                (workerId << workerIdShift) |
                sequence;
    }

    /**
     * 
     * @Title: tilNextMillis
     * @Description: 获取时间戳，并与上次时间戳比较
     * @param @param lastTimestamp
     * @param @return 参数
     * @return long 返回类型
     * @throws
     */
    private long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    /**
     * 
     * @Title: timeGen
     * @Description: 获取系统时间戳
     * @param @return 参数
     * @return long 返回类型
     * @throws
     */
    private long timeGen(){
        return System.currentTimeMillis();
    }
    
    /**
     * 
     * @Title: randomSequence
     * @Description: 生成随机不重复的序列号
     * @param @return 参数
     * @return long 返回类型
     * @throws
     */
    public static long randomSequence() {
		IntStream workerIntStream = RANDOM.ints(0, 32);
		int workerId = workerIntStream.findAny().getAsInt();
		IntStream datacenterIntStream = RANDOM.ints(0, 32);
		int datacenterId = datacenterIntStream.findAny().getAsInt();
		IntStream sequenceIntStream = RANDOM.ints(0, 4095);
		int sequenceId = sequenceIntStream.findAny().getAsInt();
    	SequenceWorker worker = new SequenceWorker(workerId,datacenterId,sequenceId);
    	return worker.nextId();
    }

    /**
     * 
     * @Title: main
     * @Description: 测试
     * @param @param args 参数
     * @return void 返回类型
     * @throws
     */
    public static void main(String[] args) {
        SequenceWorker worker = new SequenceWorker(0,0,0);
//        IdWorker worker = new IdWorker(2,1,1);
        int len = 30;
        for (int i = 0; i < len; i++) {
          //  System.out.println(worker.nextId());
        	long  rid = randomSequence();
            System.out.println(rid);
        }
    }

}