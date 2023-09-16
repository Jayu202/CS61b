package gh2;

// TODO: uncomment the following import once you're ready to start this portion
 import deque.ArrayDeque;
 import deque.Deque;
// TODO: maybe more imports

 import deque.LinkedListDeque;
 import edu.princeton.cs.algs4.StdAudio;

//Note: This file will not compile until you complete the Deque implementations(在完成Deque实现之前，此文件不会编译)

public class GuitarString {
    /** Constants. Do not change. In case you're curious, the keyword final
     * means the values cannot be changed at runtime. We'll discuss this and
     * other topics in lecture on Friday. */
    private static final int SR = 44100;      // Sampling Rate(采样率）
    private static final double DECAY = .996; // energy decay factor（能量衰减因子）

    /* Buffer for storing sound data（buffer用于存储声音数据）. */
    // TODO: uncomment the following line once you're ready to start this portion
     private Deque<Double> buffer;

    /* Create a guitar string of the given frequency（创建一个给定频率的吉他弦）.  */
    public GuitarString(double frequency) {

        buffer = new ArrayDeque<>();
        int capacity = (int) Math.round(SR / frequency);
        for (int i = 0; i < capacity; i++) {
            buffer.addLast(0.0);
        }
        // TODO: Create a buffer with capacity = SR / frequency. You'll need to
        //       cast the result of this division operation into an int. For
        //       better accuracy, use the Math.round() function before casting.
        //       Your should initially fill your buffer array with zeros.
        /*
        创建一个容量= SR /频率的缓冲区。你需要
        将除法运算的结果强制转换为int类型。为
        更好的精度，在强制转换前使用Math.round()函数。
        你应该首先用零填充你的缓冲区数组。
         */
    }


    /* (用白噪音代替缓冲弹吉他弦). */
    public void pluck() {

        for (int i = 0; i < buffer.size(); i++) {
            double r = Math.random() - 0.5;
            buffer.removeFirst();
            buffer.addLast(r);
        }
        // TODO: Dequeue everything in buffer, and replace with random numbers
        //       between -0.5 and 0.5. You can get such a number by using:
        //       double r = Math.random() - 0.5;
        //      将缓冲区中的所有内容从队列中取出，并替换为-0.5到0.5之间的随机数。
        //      你可以使用以下命令得到这样一个数字: double r = Math.random() - 0.5;
        /*
        确保你的随机数彼此不同。这并不意味着您需要检查这些数字是否彼此不同。
        这意味着您应该反复调用Math.random() - 0.5来为每个数组索引生成新的随机数
         */
    }

    /*
     * 通过对Karplus-Strong算法进行一次迭代，将仿真速度提高一个时间步。
     */
    public void tic() {
        // TODO: Dequeue the front sample and enqueue a new sample that is
        //       the average of the two multiplied by the DECAY factor.
        //       **Do not call StdAudio.play().**
        // 将前样本从队列中取出，并将两个样本的平均值乘以衰变因子的新样本放入队列中。
        // **不要调用StdAudio.play().**
//        while(true) {
            double db = ((buffer.get(0) + buffer.get(1)) / 2.0) * 0.996;
            buffer.removeFirst();
            buffer.addLast(db);
//        }
    }

    /* Return the double at the front of the buffer. */
    public double sample() {
        // TODO: Return the correct thing.
        return buffer.get(0);
    }
}
    // TODO: Remove all comments that say TODO when you're done.
