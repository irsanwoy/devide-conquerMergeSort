public class MergeSort {
    public static void main(String[] args) {
        int[] data = {38, 27, 43, 3, 9, 82, 10};

        System.out.println("Data Sebelum diurutkan:");
        cetakArray(data);

        mergeSort(data, 0, data.length - 1);

        System.out.println("\nData Setelah diurutkan:");
        cetakArray(data);
    }

    // Metode untuk mencetak elemen array
    private static void cetakArray(int[] array) {
        for (int nilai : array) {
            System.out.print(nilai + " ");
        }
        System.out.println();
    }

    // Metode untuk menggabungkan dua subarray dari array[]
    private static void gabung(int[] array, int kiri, int tengah, int kanan) {
        int n1 = tengah - kiri + 1;
        int n2 = kanan - tengah;

        // Buat array sementara
        int[] arrayKiri = new int[n1];
        int[] arrayKanan = new int[n2];

        // Salin data ke array sementara
        System.arraycopy(array, kiri, arrayKiri, 0, n1);
        System.arraycopy(array, tengah + 1, arrayKanan, 0, n2);

        // Gabungkan dua array sementara kembali ke array asli
        int i = 0, j = 0, k = kiri;
        while (i < n1 && j < n2) {
            if (arrayKiri[i] <= arrayKanan[j]) {
                array[k] = arrayKiri[i];
                i++;
            } else {
                array[k] = arrayKanan[j];
                j++;
            }
            k++;
        }

        // Salin sisa elemen (jika ada) dari arrayKiri
        while (i < n1) {
            array[k] = arrayKiri[i];
            i++;
            k++;
        }

        // Salin sisa elemen (jika ada) dari arrayKanan
        while (j < n2) {
            array[k] = arrayKanan[j];
            j++;
            k++;
        }
    }

    // Metode untuk melakukan MergeSort pada array
    private static void mergeSort(int[] array, int kiri, int kanan) {
        if (kiri < kanan) {
            // Temukan titik tengah
            int tengah = (kiri + kanan) / 2;

            // Panggil mergeSort untuk setengah kiri
            mergeSort(array, kiri, tengah);

            // Panggil mergeSort untuk setengah kanan
            mergeSort(array, tengah + 1, kanan);

            // Gabungkan kedua setengah
            gabung(array, kiri, tengah, kanan);
        }
    }
}
