public class PilhaTeste {
    public static void main(String[] args) {
        PilhaArray2 minhaPica = new PilhaArray2(8, 1);

        minhaPica.pushVermelho(1);
        minhaPica.pushVermelho(2);
        minhaPica.pushVermelho(3);
        minhaPica.pushVermelho(4);
        minhaPica.pushVermelho(5);

        //minhaPica.pushPreto(1);
        //minhaPica.pushPreto(2);
        //minhaPica.pushPreto(3);
        //minhaPica.pushPreto(4);
        //minhaPica.pushPreto(5);

        System.out.println(minhaPica);
    }
}
