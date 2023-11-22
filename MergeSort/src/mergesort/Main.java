package mergesort;

public class Main {

    // Fungsi utama untuk mencari nilai maksimal dalam array
    public static int cariNilaiMaksimal(int[] arr) {
        // Jika panjang array adalah 1, kembalikan elemen tunggal tersebut
        if (arr.length == 1) {
            return arr[0];
        }

        // Temukan indeks tengah array
        int tengah = arr.length / 2;

        // Rekursif: Cari nilai maksimal pada setengah kiri array
        int maksKiri = cariNilaiMaksimal(arr, 0, tengah - 1);

        // Rekursif: Cari nilai maksimal pada setengah kanan array
        int maksKanan = cariNilaiMaksimal(arr, tengah, arr.length - 1);

        // Gabungkan nilai maksimal dari kedua setengah array
        return Math.max(maksKiri, maksKanan);
    }

    // Fungsi rekursif untuk mencari nilai maksimal dalam suatu rentang array
    private static int cariNilaiMaksimal(int[] arr, int awal, int akhir) {
        // Jika rentang array hanya terdiri dari satu elemen, kembalikan elemen tersebut
        if (awal == akhir) {
            return arr[awal];
        }

        // Temukan indeks tengah rentang array
        int tengah = (awal + akhir) / 2;

        // Rekursif: Cari nilai maksimal pada setengah kiri rentang array
        int maksKiri = cariNilaiMaksimal(arr, awal, tengah);

        // Rekursif: Cari nilai maksimal pada setengah kanan rentang array
        int maksKanan = cariNilaiMaksimal(arr, tengah + 1, akhir);

        // Gabungkan nilai maksimal dari kedua setengah rentang array
        return Math.max(maksKiri, maksKanan);
    }

    public static void main(String[] args) {
        // Array contoh
        int[] arr = {1, 2, 3, 4, 5};

        // Cetak nilai maksimal dalam array
        System.out.println(cariNilaiMaksimal(arr));
    }
}
