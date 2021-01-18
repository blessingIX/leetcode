package cn.edu.jsu.leetcode.algorithm;

/**
 * @description: 389. 找不同
 * @author: blessing
 * @create: 2021-01-18 13:24
 */
public class Question389 {
//    https://leetcode-cn.com/problems/find-the-difference/
    public char findTheDifference(String s, String t) {
        // 哈希表法
        int[] map = new int[26];
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        for (char c : sChar) {
            map[c - 'a']++;
        }
        for (char c : tChar) {
            if (map[c - 'a'] == 0) return c;
            map[c - 'a']--;
        }
        for (int i = 0; i < map.length; i++) {
            if (map[i] > 0) return (char) (i + 'a');
        }
        return ' ';
    }

    // 算术运算法
//    https://www.bilibili.com/read/cv8044213?from=articleDetail
    public char findTheDifferenceCalc(String s, String t) {
        int sizeS = s.length();
        int sizeT = t.length();
        int total = 0;
        for (int i = 0; i < sizeT; i++) {
            total += t.charAt(i);
            if (i < sizeS) {
                total -= s.charAt(i);
            }
        }
        return (char) total;
    }

//    提交记录1ms执行范例（异或解法？）
    public char findTheDifferenceXOR(String s, String t) {
        int ans = 0;
        for(int i = t.length() - 1; i >= 0; i--) ans ^= t.charAt(i);
        for(int i = s.length() - 1; i >= 0; i--) ans ^= s.charAt(i);
        return (char) ans;
    }

    public static void main(String[] args) {
        Question389 question = new Question389();
        String[][] cases = new String[][]{
                {"abcd", "abcde"},
                {"", "y"},
                {"a", "aa"},
                {"ae", "aea"},
                {"ymbgaraibkfmvocpizdydugvalagaivdbfsfbepeyccqfepzvtpyxtbadkhmwmoswrcxnargtlswqemafandgkmydtimuzvjwxvlfwlhvkrgcsithaqlcvrihrwqkpjdhgfgreqoxzfvhjzojhghfwbvpfzectwwhexthbsndovxejsntmjihchaotbgcysfdaojkjldprwyrnischrgmtvjcorypvopfmegizfkvudubnejzfqffvgdoxohuinkyygbdzmshvyqyhsozwvlhevfepdvafgkqpkmcsikfyxczcovrmwqxxbnhfzcjjcpgzjjfateajnnvlbwhyppdleahgaypxidkpwmfqwqyofwdqgxhjaxvyrzupfwesmxbjszolgwqvfiozofncbohduqgiswuiyddmwlwubetyaummenkdfptjczxemryuotrrymrfdxtrebpbjtpnuhsbnovhectpjhfhahbqrfbyxggobsweefcwxpqsspyssrmdhuelkkvyjxswjwofngpwfxvknkjviiavorwyfzlnktmfwxkvwkrwdcxjfzikdyswsuxegmhtnxjraqrdchaauazfhtklxsksbhwgjphgbasfnlwqwukprgvihntsyymdrfovaszjywuqygpvjtvlsvvqbvzsmgweiayhlubnbsitvfxawhfmfiatxvqrcwjshvovxknnxnyyfexqycrlyksderlqarqhkxyaqwlwoqcribumrqjtelhwdvaiysgjlvksrfvjlcaiwrirtkkxbwgicyhvakxgdjwnwmubkiazdjkfmotglclqndqjxethoutvjchjbkoasnnfbgrnycucfpeovruguzumgmgddqwjgdvaujhyqsqtoexmnfuluaqbxoofvotvfoiexbnprrxptchmlctzgqtkivsilwgwgvpidpvasurraqfkcmxhdapjrlrnkbklwkrvoaziznlpor", "qhxepbshlrhoecdaodgpousbzfcqjxulatciapuftffahhlmxbufgjuxstfjvljybfxnenlacmjqoymvamphpxnolwijwcecgwbcjhgdybfffwoygikvoecdggplfohemfypxfsvdrseyhmvkoovxhdvoavsqqbrsqrkqhbtmgwaurgisloqjixfwfvwtszcxwktkwesaxsmhsvlitegrlzkvfqoiiwxbzskzoewbkxtphapavbyvhzvgrrfriddnsrftfowhdanvhjvurhljmpxvpddxmzfgwwpkjrfgqptrmumoemhfpojnxzwlrxkcafvbhlwrapubhveattfifsmiounhqusvhywnxhwrgamgnesxmzliyzisqrwvkiyderyotxhwspqrrkeczjysfujvovsfcfouykcqyjoobfdgnlswfzjmyucaxuaslzwfnetekymrwbvponiaojdqnbmboldvvitamntwnyaeppjaohwkrisrlrgwcjqqgxeqerjrbapfzurcwxhcwzugcgnirkkrxdthtbmdqgvqxilllrsbwjhwqszrjtzyetwubdrlyakzxcveufvhqugyawvkivwonvmrgnchkzdysngqdibhkyboyftxcvvjoggecjsajbuqkjjxfvynrjsnvtfvgpgveycxidhhfauvjovmnbqgoxsafknluyimkczykwdgvqwlvvgdmufxdypwnajkncoynqticfetcdafvtqszuwfmrdggifokwmkgzuxnhncmnsstffqpqbplypapctctfhqpihavligbrutxmmygiyaklqtakdidvnvrjfteazeqmbgklrgrorudayokxptswwkcircwuhcavhdparjfkjypkyxhbgwxbkvpvrtzjaetahmxevmkhdfyidhrdeejapfbafwmdqjqszwnwzgclitdhlnkaiyldwkwwzvhyorgbysyjbxsspnjdewjxbhpsvj"}
        };
        for (String[] aCase : cases) {
            System.out.printf("s = %s, t = %s\n", aCase[0], aCase[1]);
//            System.out.printf("%s\n", question.findTheDifference(aCase[0], aCase[1]));
            System.out.printf("%s\n", question.findTheDifferenceCalc(aCase[0], aCase[1]));
        }
    }
}
