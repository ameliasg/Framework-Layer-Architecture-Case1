package Main;

public class Main extends Manusia{

	public Main() {
		// TODO Auto-generated constructor stub
		Kendaraan mobil = new Kendaraan(4, "sport car");
		Kendaraan motor = new Kendaraan(2, "Motor Sport");
		
		System.out.println("Jumlah Roda:" + mobil.getJumlahRoda());
		System.out.println("Jenis: " + mobil.getJenis());
		
		namaManusia = "Budi";
		System.out.println();
		
		Manusia dewasa1 = new Manusia();
		dewasa1.greetings();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
