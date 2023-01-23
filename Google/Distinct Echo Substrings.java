class Solution {
    public int distinctEchoSubstrings(String text) {
        int n = text.length();
        HashSet<String> hs = new HashSet<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            StringBuilder s = new StringBuilder();
            for (int j = i; j < n; j++) {
                char ch = text.charAt(j);
                s.append(ch);
                if (s.length() % 2 == 0) {
                    String a = s.substring(0, s.length() / 2);
                    String b = s.substring(s.length() / 2);
                    // System.out.println(s);
                    if (a.equals(b) == true && hs.contains(a) == false) {
                        hs.add(a);
                        // System.out.println("Captured");
                        count++;
                    }
                }
            }
        }
        return count;
    }
}