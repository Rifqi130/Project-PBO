package Model.PS;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelTablePS extends AbstractTableModel {
    List<ModelPS> daftarPlaystation;

    String kolom[] = {"ID", "Nama", "Paket", "Harga","LamaSewa", "Hargatotal",};

    public ModelTablePS(List<ModelPS> daftarPlaystation) {
        this.daftarPlaystation = daftarPlaystation;
    }

    // Method untuk mengambil jumlah baris dari tabel
    @Override
    public int getRowCount() {
        return daftarPlaystation.size();
    }

    // Method untuk mengambil jumlah kolom dari tabel
    @Override
    public int getColumnCount() {
        return kolom.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return daftarPlaystation.get(rowIndex).getId();
            case 1:
                return daftarPlaystation.get(rowIndex).getNama();
            case 2:
                return daftarPlaystation.get(rowIndex).getPaket();
            case 3:
                return daftarPlaystation.get(rowIndex).getHarga();
            case 4:
                return daftarPlaystation.get(rowIndex).getLamasewa();
            case 5:
                return daftarPlaystation.get(rowIndex).getHargatotal();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return kolom[columnIndex];
    }
}
