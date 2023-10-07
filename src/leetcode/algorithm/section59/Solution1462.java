package leetcode.algorithm.section59;

import java.util.*;

/**
 * @author zhaoxq
 * @ClassName Solution1462
 * @description:
 * @date 2023年09月12日
 *
 *
 * 你总共需要上 numCourses 门课，课程编号依次为 0 到 numCourses-1 。你会得到一个数组 prerequisite ，其中 prerequisites[i] = [ai, bi] 表示如果你想选 bi 课程，你 必须 先选 ai 课程。
 * 有的课会有直接的先修课程，比如如果想上课程 1 ，你必须先上课程 0 ，那么会以 [0,1] 数对的形式给出先修课程数对。
 * 先决条件也可以是 间接 的。如果课程 a 是课程 b 的先决条件，课程 b 是课程 c 的先决条件，那么课程 a 就是课程 c 的先决条件。
 * 你也得到一个数组 queries ，其中 queries[j] = [uj, vj]。对于第 j 个查询，您应该回答课程 uj 是否是课程 vj 的先决条件。
 * 返回一个布尔数组 answer ，其中 answer[j] 是第 j 个查询的答案。
 *
 *提示：
 * 2 <= numCourses <= 100
 * 0 <= prerequisites.length <= (numCourses * (numCourses - 1) / 2)
 * prerequisites[i].length == 2
 * 0 <= ai, bi <= n - 1
 * ai != bi
 * 每一对 [ai, bi] 都 不同
 * 先修课程图中没有环。
 * 1 <= queries.length <= 104
 * 0 <= ui, vi <= n - 1
 * ui != vi
 */

public class Solution1462 {
    public static List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {

        Map<Integer, HashSet<Integer>> prerequisiteMap = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            HashSet<Integer> orDefault = prerequisiteMap.getOrDefault(prerequisites[i][0], new HashSet<>());
            orDefault.add(prerequisites[i][1]);
            prerequisiteMap.put(prerequisites[i][0],orDefault);
        }
        List<Boolean> ret = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            has(queries[i][0],queries[i][1],prerequisiteMap,ret,i);
        }
        return ret;
    }

    private static void has(int in,int out, Map<Integer,HashSet<Integer>> prerequisiteMap,List<Boolean> ret,int i){
        HashSet<Integer> list = prerequisiteMap.get(in);

        if(list.contains(out)) {
            ret.set(i,true);
            return;
        }
        for (Integer integer : list) {
            has(integer,out,prerequisiteMap,ret,i);
            HashSet<Integer> list1 = prerequisiteMap.get(integer);
            list.addAll(list1);
        }
    }

    public static void main(String[] args) {

    }
}
