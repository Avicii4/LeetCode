/**
 * Created by Harry Chou at 2019/7/17.
 */
public class NonRepeating {
    private int[] hash = new int[256];
    private StringBuffer sb = new StringBuffer();

    //Insert one char from stringstream
    public void Insert(char ch) {
        hash[ch]++;
        sb.append(ch);
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        char[] chars = sb.toString().toCharArray();
        for(char c : chars){
            if(hash[c]==1){
                return c;
            }
        }
        return '#';
    }

    public static void main(String[] args) {
        NonRepeating nonRepeating = new NonRepeating();
        nonRepeating.Insert('g');
        System.out.println(nonRepeating.FirstAppearingOnce());
        nonRepeating.Insert('o');
        System.out.println(nonRepeating.FirstAppearingOnce());
        nonRepeating.Insert('o');
        System.out.println(nonRepeating.FirstAppearingOnce());
        nonRepeating.Insert('g');
        System.out.println(nonRepeating.FirstAppearingOnce());
        nonRepeating.Insert('l');
        System.out.println(nonRepeating.FirstAppearingOnce());
        nonRepeating.Insert('e');
        System.out.println(nonRepeating.FirstAppearingOnce());

    }
}
