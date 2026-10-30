class Solution {
    public String removeDuplicates(String s) {
        StringBuilder st = new StringBuilder();   // stack ki tarah use
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int size = st.length();
            if (size > 0 && st.charAt(size - 1) == ch) {
                st.deleteCharAt(size - 1);        // pop
            } else {
                st.append(ch);                    // push
            }
        }
        return st.toString();
    }
}