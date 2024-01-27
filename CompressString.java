public class CompressString {
    public static void main(String[] args) {
        String str = "abcd";
        System.out.println(str);
        System.out.println(compressString(str));

    }
    public static String compressString(String string){
        int count = 1;
        char currentChar = string.charAt(0);
        StringBuilder result = new StringBuilder();
        for (int i=1; i<string.length(); i++){
            if (currentChar==string.charAt(i)) count++;
            else {
                result.append(currentChar).append(count);
                currentChar = string.charAt(i);
                count = 1;
            }
        }
        result.append(currentChar).append(count);
        if (result.length() > string.length()) return string;
        return result.toString();
    }
}
