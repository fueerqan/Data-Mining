/**
 * Aplikasi untuk mengubah file data menjadi format ARFF
 * 
 * @author (Muhammad Furqan)
 * @version (October 14, 2015)
 */

package com.portalbisnisbersama;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileFilter;

public class Main {
	JFrame frame;
	JButton pilihFile;
	JTextArea textDesc;
	JLabel textTitle = new JLabel("DataToARFF - Muhammad Furqan");
	JFileChooser pemilihFile;
	
	/**
	 * Main Method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Main utama = new Main();
		
		utama.Action();
	}
	
	/**
	 * Constructor dari class Main
	 */
	public Main() {
		// TODO Auto-generated constructor stub
		buatFrame();
		
		pemilihFile = new JFileChooser();
		pemilihFile.setBounds(new Rectangle(11,17,25,24));
		
		Filter FileFilter = new Filter();
		pemilihFile.setFileFilter(FileFilter);
	}
	
	/**
	 * Fungsi untuk menginisialisasi frame dan berbagai hal lain yang berhubungan
	 */
	private void buatFrame()
	{
		frame = new JFrame("DataToARFF - Muhammad Furqan");
		frame.setSize(500, 300);
		frame.setLocationRelativeTo(null);
				
		buatKomponen();
		isiDesc();
		
		frame.setVisible(true);
	}
	
	/**
	 * Fungsi untuk mengatur komponen dalam frame
	 */
	private void buatKomponen()
	{
		textDesc = new JTextArea("");
		pilihFile = new JButton("Pilih File Names");

		/*Title aplikasi*/
		JPanel panel1 = new JPanel();
		panel1.add(textTitle);
		
		/*Deskripsi langkah*/
		JPanel panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.add(textDesc);
		textDesc.setBounds(10, 10, 320, 110);
		
		/*Lainnya*/
		JPanel panel3 = new JPanel();
		panel3.setLayout(new GridLayout(1,1));
		
		panel3.add(pilihFile);

		/*Laman Aplikasi*/
		JPanel panel = (JPanel) frame.getContentPane();
		panel.setLayout(new BorderLayout());
				
		panel.add(panel1, BorderLayout.NORTH);
		panel.add(panel2, BorderLayout.CENTER);
		panel.add(panel3, BorderLayout.EAST);
	}
	
	/**
	 * Fungsi untuk mengisi teks di deskripsi
	 */
	private void isiDesc()
	{
		String kata;
		kata = "SELAMAT DATANG ...\n\nSilahkan pilih file yang berekstensi .names untuk melihat atribut yang akan anda gunakan dalam data anda.\n";
		textDesc.setText(kata);
		textDesc.setLineWrap(true);
		textDesc.setBackground(null);
		textDesc.setFocusable(false);
	}
	
	/**
	 * Fungsi untuk aksi dari tombol
	 */
	private void Action()
	{
		pilihFile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				/*menampilkan Dialog Open File*/
				int returnValue = pemilihFile.showOpenDialog(frame);
				if(returnValue == JFileChooser.APPROVE_OPTION)
				{
					String path = pemilihFile.getSelectedFile().getAbsolutePath();
					
					if(path.contains(".names"))
					{	
						Details detail = new Details();
						detail.setPath(path);
						detail.isiTeksFile();
						
						frame.setVisible(false);
					}
					else
					{
						JOptionPane.showMessageDialog(frame, "Ekstensi file yang anda pilih bukan .names");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(frame, "Ekstensi file yang anda pilih bukan .names");
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
class Filter extends FileFilter{
	
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
			if(ekstensi.equals("names"))
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

		return "(.names) names file";
	}
}
