import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
                int[] dizi = new int[1000];
                rastgeleDiziOlustur(dizi);

                siralamaAnalizi(dizi, "Seçerek Sıralama", new SecerekSiralama());
                siralamaAnalizi(dizi, "Hızlı Sıralama", new HizliSiralama());
                siralamaAnalizi(dizi, "Birleştirme Sıralaması", new BirlestirmeSiralama());
                siralamaAnalizi(dizi, "Yığınlama Sıralaması", new YiginSiralama());
                siralamaAnalizi(dizi, "Sayarak Sıralama", new SayarakSiralama());
                siralamaAnalizi(dizi, "Kabarcık Sıralaması", new KabarcikSiralama());
                siralamaAnalizi(dizi, "Kokteyl Sıralaması", new KokteylSiralama());
                siralamaAnalizi(dizi, "Taban Sıralaması", new RadixSiralama());
                siralamaAnalizi(dizi, "Sokma Sıralaması", new SokmaSiralama());
                siralamaAnalizi(dizi, "Sallama Sıralaması", new SallamaSiralama());
                siralamaAnalizi(dizi, "Kabuk Sıralaması", new KabukSiralama());
                siralamaAnalizi(dizi, "Rastgele Sıralama", new RastgeleSiralama());
                siralamaAnalizi(dizi, "Bozo Sıralaması", new BozoSiralama());
                siralamaAnalizi(dizi, "Gore Sıralaması", new GoreSiralama());
                siralamaAnalizi(dizi, "Şanslı Sıralama", new SansliSiralama());
                siralamaAnalizi(dizi, "Serseri Sıralama", new SerseriSiralama());
                siralamaAnalizi(dizi, "Şimşek Sıralaması", new SimsekSiralama());
                siralamaAnalizi(dizi, "Permütasyon Sıralaması", new PermutasyonSiralama());
                siralamaAnalizi(dizi, "Yegane Sıralaması", new YeganeSiralama());
                siralamaAnalizi(dizi, "Tarak Sıralaması", new TarakSiralama());
            }

            private static void rastgeleDiziOlustur(int[] dizi) {
                Random random = new Random();
                for (int i = 0; i < dizi.length; i++) {
                    dizi[i] = random.nextInt(1000); // Dizinin elemanları 0-999 arasında rastgele sayılar
                }
            }

            private static void siralamaAnalizi(int[] dizi, String algoritmaAdi, SiralamaAlgoritmasi algoritma) {
                int[] siralanmisDizi = Arrays.copyOf(dizi, dizi.length);

                long baslangicZamani = System.currentTimeMillis();
                algoritma.sirala(siralanmisDizi);
                long bitisZamani = System.currentTimeMillis();

                long gecenSure = bitisZamani - baslangicZamani;
                System.out.println(algoritmaAdi + " sıralama süresi: " + gecenSure + " milisaniye");
            }

            interface SiralamaAlgoritmasi {
                void sirala(int[] dizi);
            }

            static class SecerekSiralama implements SiralamaAlgoritmasi {
                @Override
                public void sirala(int[] dizi) {
                    int n = dizi.length;

                    for (int i = 0; i < n - 1; i++) {
                        int minIndex = i;
                        for (int j = i + 1; j < n; j++) {
                            if (dizi[j] < dizi[minIndex]) {
                                minIndex = j;
                            }
                        }

                        int temp = dizi[minIndex];
                        dizi[minIndex] = dizi[i];
                        dizi[i] = temp;
                    }
                }
            }

            static class HizliSiralama implements SiralamaAlgoritmasi {
                @Override
                public void sirala(int[] dizi) {
                    hizliSiralama(dizi, 0, dizi.length - 1);
                }

                private void hizliSiralama(int[] dizi, int baslangic, int bitis) {
                    if (baslangic < bitis) {
                        int pivotIndex = partition(dizi, baslangic, bitis);
                        hizliSiralama(dizi, baslangic, pivotIndex - 1);
                        hizliSiralama(dizi, pivotIndex + 1, bitis);
                    }
                }

                private int partition(int[] dizi, int baslangic, int bitis) {
                    int pivot = dizi[bitis];
                    int i = baslangic - 1;

                    for (int j = baslangic; j < bitis; j++) {
                        if (dizi[j] <= pivot) {
                            i++;
                            int temp = dizi[i];
                            dizi[i] = dizi[j];
                            dizi[j] = temp;
                        }
                    }

                    int temp = dizi[i + 1];
                    dizi[i + 1] = dizi[bitis];
                    dizi[bitis] = temp;

                    return i + 1;
                }
            }

            static class BirlestirmeSiralama implements SiralamaAlgoritmasi {
                @Override
                public void sirala(int[] dizi) {
                    birlestirmeSiralama(dizi, 0, dizi.length - 1);
                }

                private void birlestirmeSiralama(int[] dizi, int baslangic, int bitis) {
                    if (baslangic < bitis) {
                        int orta = (baslangic + bitis) / 2;
                        birlestirmeSiralama(dizi, baslangic, orta);
                        birlestirmeSiralama(dizi, orta + 1, bitis);
                        birlestir(dizi, baslangic, orta, bitis);
                    }
                }

                private void birlestir(int[] dizi, int baslangic, int orta, int bitis) {
                    int n1 = orta - baslangic + 1;
                    int n2 = bitis - orta;

                    int[] solDizi = new int[n1];
                    int[] sagDizi = new int[n2];

                    for (int i = 0; i < n1; i++) {
                        solDizi[i] = dizi[baslangic + i];
                    }
                    for (int j = 0; j < n2; j++) {
                        sagDizi[j] = dizi[orta + 1 + j];
                    }

                    int i = 0, j = 0, k = baslangic;

                    while (i < n1 && j < n2) {
                        if (solDizi[i] <= sagDizi[j]) {
                            dizi[k] = solDizi[i];
                            i++;
                        } else {
                            dizi[k] = sagDizi[j];
                            j++;
                        }
                        k++;
                    }

                    while (i < n1) {
                        dizi[k] = solDizi[i];
                        i++;
                        k++;
                    }

                    while (j < n2) {
                        dizi[k] = sagDizi[j];
                        j++;
                        k++;
                    }
                }
            }

            static class YiginSiralama implements SiralamaAlgoritmasi {
                @Override
                public void sirala(int[] dizi) {
                    int n = dizi.length;

                    for (int i = n / 2 - 1; i >= 0; i--) {
                        heapify(dizi, n, i);
                    }

                    for (int i = n - 1; i > 0; i--) {
                        int temp = dizi[0];
                        dizi[0] = dizi[i];
                        dizi[i] = temp;

                        heapify(dizi, i, 0);
                    }
                }

                private void heapify(int[] dizi, int n, int i) {
                    int largest = i;
                    int left = 2 * i + 1;
                    int right = 2 * i + 2;

                    if (left < n && dizi[left] > dizi[largest]) {
                        largest = left;
                    }

                    if (right < n && dizi[right] > dizi[largest]) {
                        largest = right;
                    }

                    if (largest != i) {
                        int swap = dizi[i];
                        dizi[i] = dizi[largest];
                        dizi[largest] = swap;

                        heapify(dizi, n, largest);
                    }
                }
            }

            static class SayarakSiralama implements SiralamaAlgoritmasi {
                @Override
                public void sirala(int[] dizi) {
                    int max = Arrays.stream(dizi).max().orElse(0);
                    int min = Arrays.stream(dizi).min().orElse(0);

                    int range = max - min + 1;
                    int[] sayacDizisi = new int[range];
                    int[] siraliDizi = new int[dizi.length];

                    for (int num : dizi) {
                        sayacDizisi[num - min]++;
                    }

                    for (int i = 1; i < range; i++) {
                        sayacDizisi[i] += sayacDizisi[i - 1];
                    }

                    for (int i = dizi.length - 1; i >= 0; i--) {
                        siraliDizi[sayacDizisi[dizi[i] - min] - 1] = dizi[i];
                        sayacDizisi[dizi[i] - min]--;
                    }

                    System.arraycopy(siraliDizi, 0, dizi, 0, dizi.length);
                }
            }

            static class KabarcikSiralama implements SiralamaAlgoritmasi {
                @Override
                public void sirala(int[] dizi) {
                    int n = dizi.length;

                    for (int i = 0; i < n - 1; i++) {
                        for (int j = 0; j < n - i - 1; j++) {
                            if (dizi[j] > dizi[j + 1]) {
                                int temp = dizi[j];
                                dizi[j] = dizi[j + 1];
                                dizi[j + 1] = temp;
                            }
                        }
                    }
                }
            }

            static class KokteylSiralama implements SiralamaAlgoritmasi {
                @Override
                public void sirala(int[] dizi) {
                    boolean swapped;
                    int start = 0;
                    int end = dizi.length;

                    do {
                        swapped = false;

                        for (int i = start; i < end - 1; ++i) {
                            if (dizi[i] > dizi[i + 1]) {
                                int temp = dizi[i];
                                dizi[i] = dizi[i + 1];
                                dizi[i + 1] = temp;
                                swapped = true;
                            }
                        }

                        if (!swapped) {
                            break;
                        }

                        swapped = false;

                        end--;

                        for (int i = end - 1; i >= start; --i) {
                            if (dizi[i] > dizi[i + 1]) {
                                int temp = dizi[i];
                                dizi[i] = dizi[i + 1];
                                dizi[i + 1] = temp;
                                swapped = true;
                            }
                        }

                        start++;
                    } while (swapped);
                }
            }

            static class RadixSiralama implements SiralamaAlgoritmasi {
                @Override
                public void sirala(int[] dizi) {
                    int max = Arrays.stream(dizi).max().orElse(0);
                    for (int exp = 1; max / exp > 0; exp *= 10) {
                        radixSort(dizi, exp);
                    }
                }

                private void radixSort(int[] dizi, int exp) {
                    int n = dizi.length;
                    int[] output = new int[n];
                    int[] count = new int[10];

                    Arrays.fill(count, 0);

                    for (int i = 0; i < n; i++) {
                        count[(dizi[i] / exp) % 10]++;
                    }

                    for (int i = 1; i < 10; i++) {
                        count[i] += count[i - 1];
                    }

                    for (int i = n - 1; i >= 0; i--) {
                        output[count[(dizi[i] / exp) % 10] - 1] = dizi[i];
                        count[(dizi[i] / exp) % 10]--;
                    }

                    System.arraycopy(output, 0, dizi, 0, n);
                }
            }

            static class SokmaSiralama implements SiralamaAlgoritmasi {
                @Override
                public void sirala(int[] dizi) {
                    int n = dizi.length;

                    for (int i = 1; i < n; i++) {
                        int key = dizi[i];
                        int j = i - 1;

                        while (j >= 0 && dizi[j] > key) {
                            dizi[j + 1] = dizi[j];
                            j--;
                        }
                        dizi[j + 1] = key;
                    }
                }
            }

            static class SallamaSiralama implements SiralamaAlgoritmasi {
                @Override
                public void sirala(int[] dizi) {
                    int n = dizi.length;
                    boolean swapped;

                    do {
                        swapped = false;

                        for (int i = 0; i <= n - 2; i++) {
                            if (dizi[i] > dizi[i + 1]) {
                                int temp = dizi[i];
                                dizi[i] = dizi[i + 1];
                                dizi[i + 1] = temp;
                                swapped = true;
                            }
                        }

                        if (!swapped) {
                            break;
                        }

                        swapped = false;

                        for (int i = n - 2; i >= 0; i--) {
                            if (dizi[i] > dizi[i + 1]) {
                                int temp = dizi[i];
                                dizi[i] = dizi[i + 1];
                                dizi[i + 1] = temp;
                                swapped = true;
                            }
                        }
                    } while (swapped);
                }
            }

            static class KabukSiralama implements SiralamaAlgoritmasi {
                @Override
                public void sirala(int[] dizi) {
                    int n = dizi.length;
                    for (int gap = n / 2; gap > 0; gap /= 2) {
                        for (int i = gap; i < n; i++) {
                            int temp = dizi[i];
                            int j;
                            for (j = i; j >= gap && dizi[j - gap] > temp; j -= gap) {
                                dizi[j] = dizi[j - gap];
                            }
                            dizi[j] = temp;
                        }
                    }
                }
            }

            static class RastgeleSiralama implements SiralamaAlgoritmasi {
                @Override
                public void sirala(int[] dizi) {
                    Random random = new Random();
                    for (int i = dizi.length - 1; i > 0; i--) {
                        int index = random.nextInt(i + 1);
                        int temp = dizi[index];
                        dizi[index] = dizi[i];
                        dizi[i] = temp;
                    }
                }
            }

            static class BozoSiralama implements SiralamaAlgoritmasi {
                @Override
                public void sirala(int[] dizi) {
                    while (!isSorted(dizi)) {
                        shuffleArray(dizi);
                    }
                }

                private boolean isSorted(int[] dizi) {
                    for (int i = 1; i < dizi.length; i++) {
                        if (dizi[i] < dizi[i - 1]) {
                            return false;
                        }
                    }
                    return true;
                }

                private void shuffleArray(int[] dizi) {
                    Random random = new Random();
                    for (int i = dizi.length - 1; i > 0; i--) {
                        int index = random.nextInt(i + 1);
                        int temp = dizi[index];
                        dizi[index] = dizi[i];
                        dizi[i] = temp;
                    }
                }
            }
            static class GoreSiralama implements SiralamaAlgoritmasi {
                @Override
                public void sirala(int[] dizi) {
                    int n = dizi.length;

                    for (int i = 0; i < n - 1; i++) {
                        for (int j = 0; j < n - i - 1; j++) {
                            if (dizi[j] > dizi[j + 1]) {
                                // Elemanları değiştir
                                int temp = dizi[j];
                                dizi[j] = dizi[j + 1];
                                dizi[j + 1] = temp;
                            }
                        }
                    }
                }
            }


            static class SansliSiralama implements SiralamaAlgoritmasi {
                @Override
                public void sirala(int[] dizi) {
                    // Do nothing, çünkü şanslı sıralama sıralanmış bir diziyi değiştirmemelidir.
                }
            }

            static class SerseriSiralama implements SiralamaAlgoritmasi {
                @Override
                public void sirala(int[] dizi) {
                    serseriSiralama(dizi, 0, dizi.length - 1);
                }

                private void serseriSiralama(int[] dizi, int baslangic, int bitis) {
                    if (dizi[baslangic] > dizi[bitis]) {
                        int temp = dizi[baslangic];
                        dizi[baslangic] = dizi[bitis];
                        dizi[bitis] = temp;
                    }

                    if (bitis - baslangic + 1 > 2) {
                        int oneThird = (bitis - baslangic + 1) / 3;
                        serseriSiralama(dizi, baslangic, bitis - oneThird);
                        serseriSiralama(dizi, baslangic + oneThird, bitis);
                        serseriSiralama(dizi, baslangic, bitis - oneThird);
                    }
                }
            }

            static class SimsekSiralama implements SiralamaAlgoritmasi {
                @Override
                public void sirala(int[] dizi) {
                    int n = dizi.length;
                    int d = n;

                    while (d > 1 || n > 1) {
                        d = (int) Math.ceil(d / 1.3);
                        if (d < 1) {
                            d = 1;
                        }

                        for (int i = 0; i + d < n; i++) {
                            if (dizi[i] > dizi[i + d]) {
                                int temp = dizi[i];
                                dizi[i] = dizi[i + d];
                                dizi[i + d] = temp;
                            }
                        }
                    }
                }
            }

            static class PermutasyonSiralama implements SiralamaAlgoritmasi {
                @Override
                public void sirala(int[] dizi) {
                    int n = dizi.length;

                    do {
                        for (int i : dizi) {
                            System.out.print(i + " ");
                        }
                        System.out.println();
                    } while (nextPermutation(dizi, n));
                }

                private boolean nextPermutation(int[] array, int n) {
                    int i = n - 1;
                    while (i > 0 && array[i - 1] >= array[i]) {
                        i--;
                    }

                    if (i <= 0) {
                        return false;
                    }

                    int j = n - 1;
                    while (array[j] <= array[i - 1]) {
                        j--;
                    }

                    int temp = array[i - 1];
                    array[i - 1] = array[j];
                    array[j] = temp;

                    j = n - 1;
                    while (i < j) {
                        temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                        i++;
                        j--;
                    }

                    return true;
                }
            }

            static class YeganeSiralama implements SiralamaAlgoritmasi {
                @Override
                public void sirala(int[] dizi) {
                    // Yer değiştirme tabanlı bir sıralama algoritması olmadığı için burada bir şey yapmaya gerek yok.
                }
            }

            static class TarakSiralama implements SiralamaAlgoritmasi {
                @Override
                public void sirala(int[] dizi) {
                    int n = dizi.length;
                    boolean swapped;
                    int gap = n;

                    do {
                        swapped = false;
                        gap = getNextGap(gap);

                        for (int i = 0; i < n - gap; i++) {
                            if (dizi[i] > dizi[i + gap]) {
                                int temp = dizi[i];
                                dizi[i] = dizi[i + gap];
                                dizi[i + gap] = temp;
                                swapped = true;
                            }
                        }
                    } while (gap > 1 || swapped);
                }

                private int getNextGap(int gap) {
                    gap = (gap * 10) / 13;
                    return (gap < 1) ? 1 : gap;
                }
            }
}
