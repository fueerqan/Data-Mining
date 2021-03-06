package com.portalbisnisbersama;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

public class ProsesKonversi {
	BacaFile baca;
		
	String judul = "", attrData, attrHasil, pathData, pathSimpan;
	String urutan = "";
	int jumlahBaris;
	int barisSekarang;
	
	String isiLabelKomen = "Membuat Komentar pada File";
	String isiLabelTitle = "Membuat Title file ARFF";
	String isiLabelAttribute = "Membuat Attribute file ARFF";
	String isiLabelData = "Mengisi data ke file ARFF";
	
	/*Bawaan*/
	String comment;
	String bawaJudul = "@RELATION ";
	String bawaAttr = "@ATTRIBUTE ";
	String bawaData = "@DATA";
		
	/**
	 * Constructor dari class ProsesKonversi
	 */
	public ProsesKonversi() {
		// TODO Auto-generated constructor stub
		baca = new BacaFile();
		
	}
	
	/**
	 * Fungsi untuk set judul data
	 * 
	 * @param judul
	 */
	public void setJudul(String judul)
	{
		String[] juduls = judul.split(" ");
		for(int i = 0; i < juduls.length; i++)
		{
			this.judul += juduls[i];
		}
	}
	
	/**
	 * Fungsi untuk set attribute data
	 * @param attr
	 */
	public void setAttrData(String attr)
	{
		this.attrData = attr;
	}
	
	/**
	 * Fungsi untuk set attribute hasil
	 * @param attr
	 */
	public void setAttrHasil(String attr)
	{
		this.attrHasil = attr;
	}
	
	/**
	 * Fungsi untuk set lokasi data
	 * @param path
	 */
	public void setPathData(String path)
	{
		this.pathData = path;
		
		/*set path dan buka file*/
		baca.setPath(pathData);
		baca.buka();
	}
	
	/**
	 * Fungsi untuk set dimana data disimpan
	 * @param path
	 */
	public void setPathSimpan(String path)
	{
		this.pathSimpan = path;
	}
	
	/**
	 * Fungsi untuk menulis jumlah baris
	 * @param baris
	 */
	public void setJumlahBaris(int baris)
	{
		this.jumlahBaris = baris;
	}
	
	/**
	 * Fungsi untuk mendapatkan urutan data dan attribute di dalam file arff nanti
	 */
	public void aturUrutan()
	{
		String[] bagiAttrHasil = attrHasil.split("\n");
		String[] bagiAttrData = attrData.split("\n");
		
		for(int i = 0; i < bagiAttrHasil.length; i++)
		{
			for(int j = 0; j < bagiAttrData.length; j++)
			{
				if(bagiAttrData[j].compareTo(bagiAttrHasil[i]) == 0)
				{
					urutan += j;
					if(i < bagiAttrHasil.length - 1)
						urutan += ",";
				}
			}
		}
	}
	
	/**
	 * Fungsi untuk membuat file arff
	 */
	public void simpanFile()
	{
		comment = "% 1. Title : " + judul + "\n%\n% 2. Sources : \n%\n% 3. Created using DataToARFF - Muhammad Furqan's Application.\n%\n%\n";
		
		int i=0;
        try{
            FileOutputStream filesave = new FileOutputStream(pathSimpan);
            
            /*cetak comment*/
            for(i = 0; i < comment.length(); i++)
            {
            	filesave.write(comment.charAt(i));
            }
            
            /*cetak bawaan judul*/
            for(i = 0; i < bawaJudul.length(); i++)
            {
            	filesave.write(bawaJudul.charAt(i));
            }
            
            /*cetak judul*/
            for(i = 0; i < judul.length(); i++)
            {
            	filesave.write(judul.charAt(i));
            }
            
            /*cetak baris baru*/
            filesave.write('\n');
            filesave.write('\n');
            
            /*cetak attribute*/
            String[] attribute = attrHasil.split("\n");
            for(i = 0; i < attribute.length; i++)
            {
            	
            	/*cetak penanda attributenya*/
            	for(int j = 0; j < bawaAttr.length(); j++)
            	{
            		filesave.write(bawaAttr.charAt(j));
            	}
            	
            	/*cetak nama attributenya*/
            	for(int j = 0; j < attribute[i].length(); j++)
            	{
            		filesave.write(attribute[i].charAt(j));
            	}
            	
            	/*cetak baris baru*/
                filesave.write('\n');
            }
            
            /*cetak baris baru*/
            filesave.write('\n');
            filesave.write('\n');
            
            /*cetak penanda data*/
            for(i = 0; i < bawaData.length(); i++)
            {
            	filesave.write(bawaData.charAt(i));
            }
            /*cetak baris baru*/
            filesave.write('\n');
            
            String isiData;
            while((isiData = baca.lanjut(urutan)) != "")
            {
            	barisSekarang = baca.getBarisSekarang();
            	for(i = 0; i < isiData.length(); i++)
            	{
            		filesave.write(isiData.charAt(i));
            	}
            }
            
            filesave.close(); /*tutup file hasil*/
            baca.tutup(); /*tutup file data*/
            
            tutupAplikasi();
        }catch(IOException errorSimpanFile){
            JOptionPane.showMessageDialog(null, "File gagal disimpan");
        }
	}
	
	/**
	 * Fungsi untuk menutup aplikasi
	 */
	private void tutupAplikasi()
	{
		JOptionPane.showMessageDialog(null, "Data berhasil di konversi ke format ARFF");
		System.exit(1);
	}
}