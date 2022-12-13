public class Assignment5 {
    public static void main(String[] args) {
        for(int i=1;i<10;i++) {
            String fold_string=paperFold(i);
            System.out.println("For "+i+" folds we get: "+fold_string+"\n");
        }
    }
    public static String reverse(String s1) {
        if (s1.length() <= 1) {
            return s1;
        }
        return s1.charAt(s1.length()-1) + reverse(s1.substring(0,s1.length()-1));
    }
    public static String converts(String s1){
        String s2 = s1.replace('v', '1');
        s2 = s2.replace('^', '2');
        s2 = s2.replace('1', '^');
        s2 = s2.replace('2', 'v');
        return s2;
    }
    public static String paperFold(int i){
        String s1 = "v";
        if (i == 1){
            s1 = "v";
            return s1;
        }
        return reverse(converts(paperFold(i-1))) + "v" + paperFold(i-1);
    }
}