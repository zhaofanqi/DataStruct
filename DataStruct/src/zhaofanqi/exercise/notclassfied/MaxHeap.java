package zhaofanqi.exercise.notclassfied;

/**
 * ���ѷ�Ϊ�� �󶥶�/С����
 * ������ȫ������ά����һά���飬���ö������� ����Ԫ��ȫ�����ڵ��������ӽڵ㣬���Ϊ�󶥶ѣ���֮ΪС����
 * ��С�����е�����������һά �����в���������ģ�
 * �����ڵ����岻��Ϊ��������ֻ��Ϊ�˽���С��������ֵ�ŵ�ǰ�棬��������
 * <p>
 * 0
 * 1                        2
 * 3                 4            5           6
 * 7        8      9        10   11   12   13    14
 * �󶥶ѣ�arr[i] >= arr[2i+1] && arr[i] >= arr[2i+2]
 * С���ѣ�arr[i] <= arr[2i+1] && arr[i] <= arr[2i+2]
 */

/**
 * @Des ����������������ô��Ҫʹ��  �ع��󶥶�+����ֵ
 * ÿ�ν��󶥶ѵĶѶ������һ��ֵ����
 */
public class MaxHeap {
    public static void main(String[] args) {

        //ÿ����һ�����ݶ���Ҫ�ع�һ�δ�����
        int[] arr = {7, 3, 8, 5, 1, 2};
        int len = 6;
        int i;
        for (i = len; i > 0; i--) {
            buildHeap(arr, i);
            Swap(arr, i);
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[j]);
            }
            System.out.println("ִ�еĴ���"+i+"\t&&");
        }

        for (i = 0; i < len; i++) {
            System.out.printf("%d\t", arr[i]);
        }
    }


    /**
     * �����󶥶�
     */
    private static void buildHeap(int[] arr, int len) {
        int i;
        int temp;

        for (i = len / 2 - 1; i >= 0; i--) {
            if (2 * i + 1 < len && arr[i] < arr[2 * i + 1]) {//����С�����ӽڵ�
                temp = arr[i];
                arr[i] = arr[2 * i + 1];
                arr[2 * i + 1] = temp;
                //�������Ժ�������жϣ����ӽڵ���ӽڵ��Ƿ��Ѿ�����ȷ�Ķ���
                if (2 * (2 * i + 1) + 1 < len && arr[2 * i + 1] < arr[2 * (2 * i + 1) + 1] || 2 * (2 * i + 2) + 2 < len && arr[2 * i + 2] < arr[2 * (2 * i + 2) + 2]) {
                    buildHeap(arr, len);
                }
            }
            if (2 * i + 2 < len && arr[i] < arr[2 * i + 2]) {// ����С���ҽڵ�
                temp = arr[i];
                arr[i] = arr[2 * i + 2];
                arr[2 * i + 2] = temp;
                // 2*i +2 ==>2*(2*i +2)+1 Ϊ��  ;2*(2*i +2) +2 Ϊ��
                if (2 * (2 * i + 2) + 1 < len && arr[2 * i + 2] < arr[2 * (2 * i + 2) + 1] || 2 * (2 * i + 2) + 2 < len && arr[2 * i + 2] < arr[2 * (2 * i + 2) + 2]) {
                    buildHeap(arr, len);
                }
            }

        }


    }

    /**
     * �����������һλ�붥��ֵ
     */
    public static void Swap(int[] arr, int len) {
        int temp;
        temp = arr[len - 1];
        arr[len - 1] = arr[0];
        arr[0] = temp;
    }

}







