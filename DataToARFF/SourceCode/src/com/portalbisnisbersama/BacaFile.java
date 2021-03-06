package com.portalbisnisbersama;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class BacaFile {
	BufferedReader baca;
	String path;
	int baris = 1;
	
	public BacaFile() {
		// TODO Auto-generated constructor stub
		baca = null;
	}
	
	public void setPath(String path)
	{
		this.path = path;
	}
	
	public void buka()
	{
		try{
			baca = new BufferedReader(new FileReader(path));
		}catch (IOException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "File data tidak bisa dibuka");
		}
	}
	
	public int getBarisSekarang()
	{
		return baris;
	}
	
	public String lanjut(String urutan)
	{
		try{
			String kataBalikin = "";
			String hasilBaca;
			
			if((hasilBaca = baca.readLine()) != null)
			{				
				String[] bagi = hasilBaca.split(",");
				String[] urut = urutan.split(",");
				
				for(int i = 0; i < urut.length; i++)
				{
					kataBalikin += bagi[Integer.parseInt(urut[i])];
					
					if(i < urut.length - 1)
					{
						kataBalikin += ",";
					}
				}
				
				kataBalikin += "\n";
				
				return kataBalikin;
				
			}
			else
			{
				return "";
			}
		}catch(IOException e)
		{
			
		}
		return "";
	}
	
	public void tutup()
	{
		try{
			baca.close();
		}catch (IOException e) {
			// TODO: handle exception
		}
	}
}
