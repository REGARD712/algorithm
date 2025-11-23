public class TakeAttendance {
    public int takeAttendance(int[] records) {
        int left = 0, right = records.length - 1;

        // 利用二分算法解决
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (records[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // 处理细节问题
        return records[left] == left ? left + 1 : left;
    }
}
