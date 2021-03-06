package com.portalbisnisbersama;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileFilter;

public class Details {
	String path, file, judul;
	JTextArea teksFile = new JTextArea();
	JTextArea teksDesc = new JTextArea();
	JTextArea teksAttrData = new JTextArea();
	JTextArea teksAttrHasil = new JTextArea();
	JFrame frame;
	JButton btnNext;
	JLabel lblFile, lblAttr;
	JLabel lblData = new JLabel("Urutan di data");
	JLabel lblHasil = new JLabel("Urutan Hasil");
	JScrollPane sp = new JScrollPane(teksFile);
	JScrollPane sp1 = new JScrollPane(teksAttrData);
	JScrollPane sp2 = new JScrollPane(teksDesc);
	JScrollPane sp3 = new JScrollPane(teksAttrHasil);
	JFileChooser pemilihFile;
	
	/**
	 * Constructor class Details
	 */
	public Details() {
		// TODO Auto-generated constructor stub
		buatFrame();
		
		isiDesc();
		
		pemilihFile = new JFileChooser();
		pemilihFile.setBounds(new Rectangle(11,17,25,24));
		
		Filter1 FileFilter = new Filter1();
		pemilihFile.setFileFilter(FileFilter);
		
		Action();
	}
	
	/**
	 * Fungsi untuk menginisialisasi frame dan hal lain yang berhubungan
	 */
	private void buatFrame()
	{
		frame = new JFrame("DataToARFF - Muhammad Furqan");
		frame.setSize(750, 550);
		frame.setLocationRelativeTo(null);
		
		komponen();
		
		frame.setVisible(true);
	}
	
	/**
	 * Fungsi untuk mengurus komponen dari frame
	 */
	private void komponen()
	{
		btnNext = new JButton("Lanjut >>");
		lblFile = new JLabel("Attribute dalam File name");
		lblAttr = new JLabel("Attribute Anda :");
		
		/*Panel untuk teksFIle*/
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(1,1));
		panel2.add(sp);
		
		/*Panel untuk file*/
		JPanel panel1 = new JPanel();
		panel1.setLayout(new BorderLayout());
		panel1.add(lblFile, BorderLayout.NORTH);
		panel1.add(panel2, BorderLayout.CENTER);
		
		/*Panel untuk teksAttr data dan hasil*/
		JPanel panel6 = new JPanel();
		panel6.setLayout(new BorderLayout());
		panel6.add(lblData, BorderLayout.NORTH);		
		panel6.add(sp1, BorderLayout.CENTER);

		JPanel panel7 = new JPanel();
		panel7.setLayout(new BorderLayout());
		panel7.add(lblHasil, BorderLayout.NORTH);
		panel7.add(sp3, BorderLayout.CENTER);
		
		JPanel panel5 = new JPanel();
		panel5.setLayout(new GridLayout(1,2));
		panel5.add(panel6);
		panel5.add(panel7);
		
		/*Panel untuk teksAttr dan teksDesc*/
		JPanel panel3 = new JPanel();
		panel3.setLayout(new GridLayout(2, 1));
		panel3.add(panel5);
		panel3.add(sp2);
		
		/*Panel untuk teksBaru*/
		JPanel panel4 = new JPanel();
		panel4.setLayout(new BorderLayout());
		panel4.add(lblAttr, BorderLayout.NORTH);
		panel4.add(panel3, BorderLayout.CENTER);
		panel4.add(btnNext, BorderLayout.SOUTH);
		
		/*Panel Utama*/
		JPanel panel = (JPanel) frame.getContentPane();
		panel.setLayout(new GridLayout(1,2));
		panel.add(panel1);
		panel.add(panel4);
	}
	
	/**
	 * Fungsi yang mengatur teksDesc
	 */
	private void isiDesc()
	{
		String kata = "CARA PENULISAN : \n\n <nama-attribute> <type>\n <nama-attribute> <type>\nContoh : \n Id numeric\n Ukuran {S, M, L}\n\n<type> YANG TERSEDIA : \n1. numeric\n2. integer\n3. real\n4. {kategori1, kategori2, ...}\n5. date [<date-format>]\n\nPada kolom urutan di data, attribute ditulis sesuai dengan urutan di data. Pada kolom urutan hasil, di tulis sesuai dengan urutan yang diinginkan di hasil dan yang tidak dibutuhkan tidak perlu di tuliskan.";
		teksDesc.setText(kata);
		teksDesc.setLineWrap(true);
		teksDesc.setBackground(null);
		teksDesc.setFocusable(false);
	}
	
	/**
	 * Fungsi yang mengatur teksFile
	 */
	public void isiTeksFile()
	{
		olahFile();
		
		teksFile.setText(file);
		teksFile.setLineWrap(true);
		teksFile.setEditable(false);
		
	}
	
	/**
	 * Fungsi untuk menerima path yang di kirim dari class Main
	 * 
	 * @param path
	 */
	public void setPath(String path){
		this.path = path;
	}
	
	/**
	 * Fungsi untuk mengolah file yang telah di pilih oleh user
	 */
	private void olahFile()
	{
		FileInputStream f = null;
		try{
			f = new FileInputStream(path);
			String str = "";
			int b = 0;
			
			while( b != -1)
			{
				b = f.read();
				
				if((char) b != '\n')
				{
					str += (char) b;
				}
				else
				{
					str += (char) b;
					
					if(str.contains("Title"))
					{
						int last = str.lastIndexOf(":");
						
						judul = str.substring(last+1);
						judul = judul.trim();
						
						str = "";
						
					}
					else if(str.contains("Attribute"))
					{
						if(str.contains("8. Missing"))
						{
							int begin = str.lastIndexOf("7. Attribute");
							int last = str.lastIndexOf("8. Missing");
							
							file = str.substring(begin, last-1);
							str = "";
							
							break;
						}
					}
				}
			}
			
			f.close();
		}catch(IOException error)
		{
			JOptionPane.showMessageDialog(frame, "File gagal dibuka");
		}
	}
	
	/**
	 * Fungsi untuk memberikan aksi pada tombol
	 */
	public void Action()
	{
		btnNext.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				if(teksAttrData.getText().toString().equals("") && teksAttrHasil.getText().toString().equals(""))
				{
					JOptionPane.showMessageDialog(frame, "Harap isi Atrribute untuk data anda");
				}
				else
				{
					JOptionPane.showMessageDialog(frame, "Silahkan pilih file Data (.data) anda");
					
					/*menampilkan file chooser*/
					int returnValue = pemilihFile.showOpenDialog(frame);
					
					if(returnValue == JFileChooser.APPROVE_OPTION)
					{
						String path = pemilihFile.getSelectedFile().getAbsolutePath();
						
						if(path.contains(".data"))
						{	
							HasilConvert hasil = new HasilConvert();
							hasil.setPath(path);
							hasil.setAttrData(teksAttrData.getText().toString() + "\n");
							hasil.setAttrHasil(teksAttrHasil.getText().toString() + "\n");
							hasil.setJudul(judul);
							hasil.hitungBaris();
							
							frame.setVisible(false);
						}
						else
						{
							JOptionPane.showMessageDialog(frame, "Ekstensi file yang anda pilih bukan .data");
						}
					}
					else
					{
						JOptionPane.showMessageDialog(frame, "Ekstensi file yang anda pilih bukan .data");
					}
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
class Filter1 extends FileFilter{
	
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
			if(ekstensi.equals("data"))
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

		return "(.data) data file";
	}
}