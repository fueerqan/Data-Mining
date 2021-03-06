package com.portalbisnisbersama;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;


public class HasilConvert {
	
	JFrame frame;
	String path, attributData, judul, attributHasil;
	JLabel lblbaris = new JLabel("Jumlah baris : ");
	JLabel lblJlhBaris = new JLabel();
	JLabel lblTitle = new JLabel("DataToARFF - Muhammad Furqan");
	JButton btnConvert = new JButton("Konversikan");
	int baris = 0;
	BufferedReader baca = null;
	JFileChooser pemilihFile;
	
	/**
	 * Constructor class HasilConvert
	 */
	public HasilConvert() {
		// TODO Auto-generated constructor stub
		
		buatFrame();
		
		/*File Chooser*/
		pemilihFile = new JFileChooser();
		pemilihFile.setBounds(new Rectangle(11,17,25,24));
		Filter2 FileFilter = new Filter2();
		pemilihFile.setFileFilter(FileFilter);
	}
	
	/**
	 * Fungsi yang berhubungan dengan frame dan komponennya
	 */
	private void buatFrame()
	{
		frame = new JFrame("DataToARFF - Muhammad Furqan");
		frame.setSize(300, 200);
		frame.setLocationRelativeTo(null);
		
		komponen();
		Action();
		
		frame.setVisible(true);
	}
	
	/**
	 * Fungsi yang berhubungan dengan komponen dalam frame
	 */
	private void komponen()
	{
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(1, 2));
		
		panel1.add(lblbaris);
		panel1.add(lblJlhBaris);
		
		/*JPanel utama*/
		JPanel panel = (JPanel) frame.getContentPane();
		panel.setLayout(new BorderLayout());
		
		panel.add(lblTitle, BorderLayout.NORTH);
		panel.add(panel1, BorderLayout.CENTER);
		panel.add(btnConvert, BorderLayout.SOUTH);
	}
	
	/**
	 * Fungsi untuk mengisi path file data
	 * 
	 * @param path
	 */
	public void setPath(String path)
	{
		this.path = path;
	}
	
	/**
	 * Fungsi untuk mengisi attribut dari data
	 * @param attr
	 */
	public void setAttrData(String attr)
	{
		this.attributData = attr;
	}
	
	/**
	 * Fungsi untuk mengisi attribut sesuai urutan di hasil
	 * @param attr
	 */
	public void setAttrHasil(String attr)
	{
		this.attributHasil = attr;
	}
	
	/**
	 * Fungsi untuk mengisi judul dari data
	 * @param judul
	 */
	public void setJudul(String judul)
	{
		this.judul = judul;
	}
	
	/**
	 * Fungsi untuk menghitung baris dari file yang telah di pilih oleh user
	 */
	public void hitungBaris()
	{
		try{
			baca = new BufferedReader(new FileReader(path));
			
			while (baca.readLine() != null) {
				baris++;
			}
			
			lblJlhBaris.setText(Integer.toString(baris));
			
			baca.close();
		}catch(IOException e){
			JOptionPane.showMessageDialog(frame, "File tidak bisa dibuka");			
		}
			
	}
	
	/**
	 * Fungsi untuk memberikan fungsi ketika tombol di klik
	 */
	public void Action()
	{
		btnConvert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(frame, "Jangan lupa tambahkan .arff di ujung nama file yang ingin anda simpan");
				
				int returnVal = pemilihFile.showSaveDialog(frame);
                if(returnVal == JFileChooser.APPROVE_OPTION) {
                	String pathSekarang = pemilihFile.getSelectedFile().getAbsolutePath();
                	
                	ProsesKonversi konversi = new ProsesKonversi();
                	konversi.setJudul(judul);
                	konversi.setAttrData(attributData);
                	konversi.setAttrHasil(attributHasil);
                	konversi.aturUrutan();
                	konversi.setPathData(path);
                	konversi.setPathSimpan(pathSekarang);
                	konversi.setJumlahBaris(baris);
                	konversi.simpanFile();
                	
                	btnConvert.setEnabled(false);
                }
			}
		});
	}
}

/**
 * Class untuk mengatur filter terhadap file yang di pilih oleh file chooser
 * 
 * @author (Muhammad Furqan)
 *
 */
class Filter2 extends FileFilter{
	
	public boolean accept(File f)
	{
		if(f.isDirectory())
		{
			return true;
		}
		
		String eks = null;
		String nama = f.getName();
		
		int i = nama.lastIndexOf('.');
		if( i > 0 && i < nama.length() - 1)
		{
			eks = nama.substring(i+1).toLowerCase(); //untuk mengetahui ekstensi dari file
		}
		
		String ekstensi = eks;
		if(ekstensi != null)
		{
			if(ekstensi.equals("arff"))
			{
				return true;
			}
			else 
			{
				return false;
			}
		}
		return false;
	}
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub

		return "(.ARFF) ARFF file";
	}
}