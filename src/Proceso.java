public class Proceso
{
    private String id;
    private int exeTime;
    private int tInicial;
    private int tFinal;
    // bloqueos, cambios pertenecen al micro? o a proceso?


    public Proceso(String id, int exeTime) {
        this.id = id;
        this.exeTime = exeTime;
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
}
