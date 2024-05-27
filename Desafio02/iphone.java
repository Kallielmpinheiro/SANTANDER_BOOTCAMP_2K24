interface IReprodutorMusical {
    void play();
    void pause();
    void stop();
    void nextTrack();
    void previousTrack();
}

interface IAparelhoTelefonico {
    void fazerChamada(String numero);
    void receberChamada(String numero);
    void desligarChamada();
}

interface INavegadorInternet {
    void abrirPagina(String url);
    void voltarPagina();
    void avancarPagina();
    void fecharPagina();
}

public class iphone implements IReprodutorMusical, IAparelhoTelefonico, INavegadorInternet {
    @Override
    public void play() {}

    @Override
    public void pause() {}

    @Override
    public void stop() {}

    @Override
    public void nextTrack() {}

    @Override
    public void previousTrack() {}

    @Override
    public void fazerChamada(String numero) {}

    @Override
    public void receberChamada(String numero) {}

    @Override
    public void desligarChamada() {}

    @Override
    public void abrirPagina(String url) {}

    @Override
    public void voltarPagina() {}

    @Override
    public void avancarPagina() {}

    @Override
    public void fecharPagina() {}
}
