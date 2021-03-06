public class Proceso
{
    private String id;
    private int exeTime;
    private int entryTime;
    private int TCC =0;     // por default es 0
    private int TVC;
    private int TB;
    private int total;
    private int tInicial;
    private int tFinal;


    public Proceso(String id, int exeTime, int entryTime) {
        this.id = id;
        this.exeTime = exeTime;
        this.entryTime = entryTime;
    }

    public int getExeTime() {
        return exeTime;
    }

    public void settFinal(int tFinal) {
        this.tFinal = tFinal;
    }

    public int gettFinal() {
        return tFinal;
    }

    public int getInicial() {
        return tInicial;
    }

    public void settInicial(int tInicial) {
        this.tInicial = tInicial;
    }

    public String getId() {
        return id;
    }

    public void setTCC(int TCC) {
        this.TCC = TCC;
    }

    public void setTVC(int TVC) {
        this.TVC = TVC;
    }

    public void setTB(int TB) {
        this.TB = TB;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setEntryTime(int entryTime){
        this.entryTime = entryTime;
    }

    public int getTCC() {
        return TCC;
    }

    public int getTVC() {
        return TVC;
    }

    public int getTB() {
        return TB;
    }

    public int getTotal() {
        return total;
    }

    public int gettInicial() {
        return tInicial;
    }

    public int getEntryTime(){
        return entryTime;
    }

    @Override
    public String toString() {
        return "Proceso{" +
                "id='" + id + '\'' +
                ", exeTime=" + exeTime +
                '}';
    }
}
