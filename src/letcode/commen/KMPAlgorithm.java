package letcode.commen;

public class KMPAlgorithm {

    /**
     *  获取next数组
     *  模式串 t 的每个元素 t[j]，都存在一个实数 k ，使得模式串 t 开头的 k 个字符（t[0] t [1]…t [k-1]）依次与 t [j]
     *  前面的 k（t [j-k] t [j-k+1]…t [j-1]，这里第一个字符 t [j-k] 最多从 t [1] 开始，所以 k < [j]）个字符相同。
     *  如果这样的 k 有多个，则取最大的一个
     *
     */
    public static int[] getNext(String a){
        int next[] = new int[a.length()];
        int m =0,n=-1;
        next [0]=-1;
        while(m<a.length()-1){
            /**
             * n == -1表示首次进入，需要加一位开始计算。
             * a.charAt(m) == a.charAt(n)表示前后匹配，此时m节点的next的值等于n节点next的值。
             * 原因是：next[0]=-1,如果a.charAt(m) == a.charAt(n)不等n会一直在0和-1之间变化，直到相等才会累加。
             * 相等之后m和n同时增加，如果还相等则符合next值的定义，一直会累加。
             * 直到增加一次之后不再相等，此时计算n=next[n],此时n的值会变化（变小），如果next[n]不为0，那么charAt(next[n])=charAt(n)，此时变化后
             * 判断还不成立，n会继续变化，直到n回到-1，即起点位置，重新开始从头匹配，这也符合next的定义。
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
