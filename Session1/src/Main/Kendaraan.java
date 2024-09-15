package Main;

public class Kendaraan {
	private int jumlahRoda;
	private String jenis;

	public Kendaraan(int jumlahRoda, String jenis) {
		// TODO Auto-generated constructor stub
		this.jumlahRoda = jumlahRoda;
		this.jenis = jenis;
		
	}
	
	public int getJumlahRoda() {
		return jumlahRoda;
	}

	public void setJumlahRoda(int jumlahRoda) {
		this.jumlahRoda = jumlahRoda;
	}

	public String getJenis() {
		return jenis;
	}

	public void setJenis(String jenis) {
		this.jenis = jenis;
	}

	public void jalan() {
		System.out.println(jenis + " berjalan...");
	}

}
