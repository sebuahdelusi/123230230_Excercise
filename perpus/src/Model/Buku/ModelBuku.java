/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Buku;

/**
 *
 * @author JOY
 */
public class ModelBuku {
    private Integer id, tahun, alur, bahasa, orisinalitas;
    private String judul, penulis;
    private Float rating;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getTahun() {
        return tahun;
    }
    public void setTahun(Integer tahun) {
        this.tahun = tahun;
    }
    
    public Integer getAlur() {
        return alur;
    }
    public void setAlur(Integer alur) {
        this.alur = alur; updateRating();
    }
    
    public Integer getBahasa() {
        return bahasa;
    }
    public void setBahasa(Integer bahasa) {
        this.bahasa = bahasa; updateRating();
    }
    
    public Integer getOrisinalitas() {
        return orisinalitas;
    }
    public void setOrisinalitas(Integer orisinalitas) {
        this.orisinalitas = orisinalitas; updateRating();
    }
    
    public String getJudul() {
        return judul;
    }
    public void setJudul(String judul) {
        this.judul = judul;
    }
    
    public String getPenulis() {
        return penulis;
    }
    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }
    
    public Float getRating() {
        return rating;
    }
    private void updateRating() {
    if (alur != null && bahasa != null && orisinalitas != null)
        this.rating = (alur + bahasa + orisinalitas) / 3.0f;
    }
}
