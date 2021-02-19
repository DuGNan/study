package util.time;

/**
 * @Author 杜广楠
 * @Description
 * @Date 2/1/2021 11:55 AM
 */
public class TimeUtils {
    /**
     * @return 当前毫秒数
     */
    public static long nowMs() {
        return System.currentTimeMillis();
    }

    /**
     * 当前毫秒与起始毫秒差
     * @param startMillis 开始纳秒数
     * @return 时间差
     */
    public static long diffMs(long startMillis) {
        return diffMs(startMillis, nowMs());
    }

    /**
     * 当前毫秒与起始毫秒差
     * @param startMillis 开始纳秒数
     * @return 时间差
     */
    public static long diffMs(long startMillis, long nowMs) {
        return nowMs - startMillis;
    }
}
