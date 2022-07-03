public class Dragon {
    private int min = 0;
    private int max = 3;
    public int dragon = Integer.valueOf((int) (Math.random() * (max - min) + min));
    public int getDragon(int dragon){
        this.dragon = dragon;
        return dragon;
    }
}
