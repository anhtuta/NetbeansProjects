/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object_stream;

/**
 *
 * @author AnhTu
 */
import java.io.Serializable;
public class Pupil implements Serializable {
    private static final long serialVersionUID = -8501383434011302991L;

    private String fullName;

    public Pupil(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

}
