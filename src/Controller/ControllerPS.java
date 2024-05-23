/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import Model.PS.*;
import java.util.*;
import View.mainView;
import javax.swing.JOptionPane;

public class ControllerPS {
    mainView frame;
    InterfaceDAOPS impdataps;
    List<ModelPS> ps;
    
    public ControllerPS(mainView frame){
    this.frame = frame;
    impdataps = new DAOPS();
    ps = impdataps.getAll();
    }
    
    public void isitabel (){
        ps = impdataps.getAll();
        ModelTablePS mm = new ModelTablePS(ps);
        frame.getTabelps().setModel(mm);
    }
    
 public void insert(){
     ModelPS ps = new ModelPS();
     
     ps.setNama(frame.getTxtnama().getText());
     
     String Paket = (String) frame.getTxtpaket().getSelectedItem();
     ps.setPaket(Paket);
     
     String harga = frame.getTxtharga().getText();
     ps.setHarga(Integer.parseInt(harga));
     
     String lamasewa = frame.getTxtlamasewa().getText();
     ps.setLamasewa(Integer.parseInt(lamasewa));
     
     String hargatotal = frame.getTxthargatotal().getText();
     ps.setHargatotal(Integer.parseInt(hargatotal));
     
     impdataps.insert(ps);
     
    }
 
 public void update() {
    try {
     ModelPS ps = new ModelPS();
     
     ps.setNama(frame.getTxtnama().getText());
     
     String Paket = (String) frame.getTxtpaket().getSelectedItem();
     ps.setPaket(Paket);
     
     String harga = frame.getTxtharga().getText();
     ps.setHarga(Integer.parseInt(harga));
     
     String lamasewa = frame.getTxtlamasewa().getText();
     ps.setLamasewa(Integer.parseInt(lamasewa));
     
     String hargatotal = frame.getTxthargatotal().getText();
     ps.setHargatotal(Integer.parseInt(hargatotal));

     impdataps.update(ps);
     JOptionPane.showMessageDialog(null, "Data berhasil diperbarui.", "Sukses", JOptionPane.INFORMATION_MESSAGE);
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(null, "Input tidak valid: " + ex.getMessage(), "Kesalahan Input", JOptionPane.ERROR_MESSAGE);
    } catch (IllegalArgumentException ex) {
        JOptionPane.showMessageDialog(null, ex.getMessage(), "Kesalahan Input", JOptionPane.ERROR_MESSAGE);
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + ex.getMessage(), "Kesalahan", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace(); // Menambahkan pencatatan pengecualian ke dalam log
    }
}

  public void delete(){
int id = Integer.parseInt(frame.getTxtid().getText());
impdataps.delete(id);

    }

}
