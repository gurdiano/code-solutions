// https://neetcode.io/problems/string-encode-and-decode/question

// O(n)
class Solution {

    public String encode(List<String> strs) {
        String open, close;
        StringBuilder res = new StringBuilder();

        open = "$<";
        close = ">$";

        for (String str: strs) {
            res.append(open);
            res.append(str);
            res.append(close);
        }   

        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();

        boolean open = false;
        boolean close = false;
        int marker = 0;
        for(int i = 0; i < str.length() - 1; i++) {
            String special = "" + str.charAt(i) + str.charAt(i + 1);

            if(special.equals("$<")) {
                marker = i + 2;
                open = true;
            }
            if(special.equals(">$")) close = true;

            if(open && close) {
                res.add(str.substring(marker, i));

                marker = 0;
                open = false;
                close = false;
            }
        }

        return res;
    }
}
