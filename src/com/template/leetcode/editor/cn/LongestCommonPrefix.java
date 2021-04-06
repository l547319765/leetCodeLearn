//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 0 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 
// 👍 1546 👎 0

package com.template.leetcode.editor.cn;

import java.util.Collections;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
        solution.longestCommonPrefix(new String[]{"ab", "a"});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0) {
                return "";
            }
            StringBuilder stringBuilder = new StringBuilder();
            char[] resultChars = new char[200];
            int resultCharsNum = strs[0].length();
            System.arraycopy(strs[0].toCharArray(), 0, resultChars, 0, strs[0].length());
            char[] chars;
            for (String str : strs) {
                chars = str.toCharArray();
                int length = chars.length;
                resultCharsNum = Math.min(length, resultCharsNum);
                for (int i = 0; i < length; i++) {
                    if (chars[i] != resultChars[i]) {
                        resultCharsNum = Math.min(i, resultCharsNum);
                        break;
                    }
                }
            }
            for (int i = 0; i < resultCharsNum; i++) {
                stringBuilder.append(resultChars[i]);
            }
            return stringBuilder.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}