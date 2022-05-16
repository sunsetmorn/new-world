package letcode.commen;

public class KMPAlgorithm {

    /**
     *  ��ȡnext����
     *  ģʽ�� t ��ÿ��Ԫ�� t[j]��������һ��ʵ�� k ��ʹ��ģʽ�� t ��ͷ�� k ���ַ���t[0] t [1]��t [k-1]�������� t [j]
     *  ǰ��� k��t [j-k] t [j-k+1]��t [j-1]�������һ���ַ� t [j-k] ���� t [1] ��ʼ������ k < [j]�����ַ���ͬ��
     *  ��������� k �ж������ȡ����һ��
     *
     */
    public static int[] getNext(String a){
        int next[] = new int[a.length()];
        int m =0,n=-1;
        next [0]=-1;
        while(m<a.length()-1){
            /**
             * n == -1��ʾ�״ν��룬��Ҫ��һλ��ʼ���㡣
             * a.charAt(m) == a.charAt(n)��ʾǰ��ƥ�䣬��ʱm�ڵ��next��ֵ����n�ڵ�next��ֵ��
             * ԭ���ǣ�next[0]=-1,���a.charAt(m) == a.charAt(n)����n��һֱ��0��-1֮��仯��ֱ����ȲŻ��ۼӡ�
             * ���֮��m��nͬʱ���ӣ��������������nextֵ�Ķ��壬һֱ���ۼӡ�
             * ֱ������һ��֮������ȣ���ʱ����n=next[n],��ʱn��ֵ��仯����С�������next[n]��Ϊ0����ôcharAt(next[n])=charAt(n)����ʱ�仯��
             * �жϻ���������n������仯��ֱ��n�ص�-1�������λ�ã����¿�ʼ��ͷƥ�䣬��Ҳ����next�Ķ��塣
             */
            if (n == -1 || a.charAt(m) == a.charAt(n)) {
                m++;
                n++;
                next[m]=n;
            }else{
                n = next[n];  //
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String a= "anjfbanhsbk";
        int[] b =getNext(a);
        System.out.println("61544");
    }
}
