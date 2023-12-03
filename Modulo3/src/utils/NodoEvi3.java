package utils;

import java.io.Serializable;

public class NodoEvi3 implements Serializable {
    private String pregunta;
    private NodoEvi3 hijoSi;
    private NodoEvi3 hijoNo;

    public NodoEvi3(String pregunta) {
        this.pregunta = pregunta;
    }

    public String obtenerPregunta() {
        return pregunta;
    }

    public NodoEvi3 obtenerHijoSi() {
        return hijoSi;
    }

    public NodoEvi3 obtenerHijoNo() {
        return hijoNo;
    }

    public void establecerHijoSi(NodoEvi3 hijoSi) {
        this.hijoSi = hijoSi;
    }

    public void establecerHijoNo(NodoEvi3 hijoNo) {
        this.hijoNo = hijoNo;
    }

    public boolean esHoja() {
        return hijoSi == null && hijoNo == null;
    }

    public String obtenerMensajeAdivinanza() {
        return "Tu animal es: " + pregunta;
    }
}
