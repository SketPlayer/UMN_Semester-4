package uas_praktik_oop_i;

public class Rio_Order {
	private int orderId;
	private Rio_Pelanggan customer;
	private Rio_Item itemTerpilih;
	private int qtyItem;
	private double totalHarga;
	
	public Rio_Order(int orderId, Rio_Pelanggan customer, Rio_Item itemTerpilih, int qtyItem) {
		this.orderId = orderId;
		this.customer = customer;
		this.itemTerpilih = itemTerpilih;
		this.qtyItem = qtyItem;
	}
	
	public String printDetailOrder() {
		if (itemTerpilih instanceof Rio_Merchandise) {
			return "Order ID: " + orderId +
					"\nPelanggan: " + customer +
					"\nBarang: Merchandise: " + itemTerpilih.getNama() +
					"\nJumlah: " + qtyItem +
					"\nTotal Harga: " + totalHarga;
		}
		else if (itemTerpilih instanceof Rio_TiketKonser) {
			return "Order ID: " + orderId +
					"\nPelanggan: " + customer +
					"\nBarang: Tiket Konser: " + itemTerpilih.getNama() +
					"\nJumlah: " + qtyItem +
					"\nTotal Harga: " + totalHarga;
		}
		else if (itemTerpilih instanceof Rio_RekamanKonser) {
			return "Order ID: " + orderId +
					"\nPelanggan: " + customer +
					"\nBarang: Rekaman Konser: " + itemTerpilih.getNama();
		}
		return null;
	}
}
