import java.util.*;

public class Containers {
    public static void main(String[] args) {
        System.out.println("\n--- LListes1 ---");
        llistes1();
        System.out.println("\n--- Iterators ---");
        iterators();
        System.out.println("\n--- Cua ---");
        cues();
        System.out.println("\n--- Piles ---");
        piles();
        System.out.println("\n--- Conjunts ---");
        conjunts();
        System.out.println("\n--- Mapes ---");
        mapes();

    }

    static void llistes1() {
        // Crea llista d'enters anomenada "l1"
        List<Integer> l1 = new ArrayList<>();

        // Afegeix els números 10, 20 i 15
        /*l1.add(10);
        l1.add(20);
        l1.add(15);*/

        l1.addAll(List.of(10, 20, 15));

        // Imprimeix la llista
        System.out.println(l1);

        // Elimina el segon element
        l1.remove(1);

        // Imprimeix la llista
        System.out.println(l1);

        // Crea llista d'enters anomenada "l2"
        List<Integer> l2 = new ArrayList<>();

        // Afegeix els números 3, 6 i 9
        l2.add(3);
        l2.add(6);
        l2.add(9);

        // Afegeix la llista l1 a la llista l2
        l2.addAll(l1);

        // Imprimeix la llista l2
        System.out.println(l2);

        // Elimina tots els valors de l1
        l1.clear();

        // Afegeix els tres primers elements de l2 a l1
        // for (int i = 0; i < 3; i++) l1.add(l2.get(i));
        l1.addAll(l2.subList(0, 3));

        // Comprova si dins l1 hi ha el número 6
        System.out.println(l1.contains(6));

        // Afegeix el numero 6 un altre cop a l1 al principi de la llista
        l1.add(0, 6);

        // Cerca la posicio de l'element que te el numero 9 a la llista l1
        System.out.println(l1.indexOf(9));

        // A l1, substitueix l'element a la posició 1 per el valor 5
        l1.set(1, 5);

        // A l1, insereix a la posició 2 l'element 4
        l1.add(2, 4);

        // Imprimeix la llista l1
        System.out.println(l1);

        // Converteix l1 a array i imprimeix-ho
        Integer[] array = l1.toArray(new Integer[0]);
        System.out.println(Arrays.toString(array));
    }

    static void iterators() {
        // Crea llista d'enters anomenada "l1"
        List<Integer> l1 = new ArrayList<>();

        // Afegeix a l1 els elements 10, 20, 50 i 90
        int[] array = {10, 20, 50, 90};
        for (int i : array) l1.add(i);

        // Treu Iterator (it)
        Iterator<Integer> it = l1.iterator();

        // Mentre hi hagi element següent, imprimeix l'element
        while (it.hasNext()) System.out.println(it.next());


        // Torna a crear l'objecte iterator i has de recórrer la llista, però has d'esborrar l'element "50"
        it = l1.iterator();

        while (it.hasNext()) {
            if (it.next() == 50) it.remove();
        }

        // Imprimeix la llista
        System.out.println();
        for (int n : l1) System.out.println(n);

        // Crea un ListIterator de la llista l1 (anomenat "li") 
        ListIterator<Integer> li = l1.listIterator();

        // Avança l'iterador fins al final de la llista
        while (li.hasNext()) li.next();

        // Recorre la llista al reves amb l'iterador, imprimint els elements
        System.out.println();
        while (li.hasPrevious()) System.out.println(li.previous());

        // Torna a recorrer la llista amb l'iterador, pero aquest cop imprimeix tambe l'index de l'element
        System.out.println();
        while (li.hasNext()) {
            System.out.println("The next index is " + li.nextIndex() + " and its value is " + li.next());
        }
    }

    static void cues() {
        // Declara una cua (anomenada "cua") com una LinkedList
        Queue<Integer> cua = new LinkedList<>();

        // Afegeix els elements 12, 14 i 99 a la cua
        int[] array = {12, 14, 99};
//        for (int n : array) cua.add(n);
        for (int n : array) cua.offer(n);

        // Mostra el primer element (sense treurer-lo) de la cúa i imprimeix-ho
//        System.out.println(cua.stream().findFirst().get());
        System.out.println(cua.peek());

        // Treu el primer element de la cúa
//        cua.remove();
        cua.poll();

        // Imprimeix la cúa
        System.out.println("\n" + cua + "\n");

        // Declara una cúa de prioritat anomenada "cuaPrioritat"
        Queue<Integer> cuaPrioritat = new PriorityQueue<>();

        // Afegeix els elements 5, 2, -1, 9 i 7
        array = new int[]{5, 2, -1, 9, 7};
//        for (int n : array) cuaPrioritat.add(n);
        for (int n : array) cuaPrioritat.offer(n);

        // Imprimeix la cúa
        System.out.println(cuaPrioritat);

        // Fes un bucle que vagi traient cada element i l'imprimeixi de la cúa de prioritat, mentre en quedin
        while (!cuaPrioritat.isEmpty()) {
//            System.out.println(cuaPrioritat.stream().findFirst().get());
//            cuaPrioritat.remove();
            System.out.println(cuaPrioritat.poll());
        }

    }

    static void piles() {
        // Declara una pila (stack) com una LinkedList
        LinkedList<Integer> pila = new LinkedList<>();

        // Push a la pila dels valors 15, 56, 21 i -5
        int[] array = {15, 56, 21, -5};
        for (int n : array) pila.push(n);

        // Imprimeix la pila
        System.out.println(pila);

        // Imprimeix el valor de damunt la pila, sense treurer-lo
        System.out.println(pila.getFirst());

        // Treu i imprimeix els valors de la pila
        while (!pila.isEmpty()) System.out.println(pila.pop());
    }

    static void conjunts() {
        // Declara un conjunt d'enters anomenat "set"
        Set<Integer> set = new HashSet<>();

        // Afegeix els elements 14, 6 i 3
        int[] array = {14, 6, 3};
        for (int n : array) set.add(n);

        // Imprimeix el conjunt
        System.out.println(set);

        // Afegeix l'element 6 un altre cop
        set.add(6);

        // Imprimeix el conjunt
        System.out.println(set );

        // Construeix un conjunt de caràcters anomenat set2 (Usa la class Character, no char)
        // i introdueix totes les lletres de la paraula "ESTERNOCLEIDOMASTOIDEO"
        // Després, imprimeix el conjunt
        Set<Character> set2 = new HashSet<>();
        for (char c : "ESTERNOCLEIDOMASTOIDEO".toCharArray()) set2.add(c);

        // Empra un iterador (it) per recórrer tot el conjunt de caràcters anterior i imprimeix element a element
        Iterator<Character> it = set2.iterator();
        while (it.hasNext()) System.out.println(it.next());
    }

    static void mapes() {
        // Construeix un mapa (map) que associi un String amb un altre String
        Map<String,String> map = new HashMap<>();

        // Introdueix el parell: "RENAULT" - "CLIO"
        map.put("RENAULT", "CLIO");

        // Introdueix el parell: "VOLKSWAGEN" - "GOLF"
        map.put("VOLKSWAGEN", "GOLF");

        // Introdueix el parell: "PEUGEOT" - "308"
        map.put("PEUGEOT", "308");

        // Introdueix el parell: "HONDA" - "CIVIC"
        map.put("HONDA", "CIVIC");

        // Introdueix el parell: "PEUGEOT" - "RCZ"
        map.put("PEUGEOT", "RCZ");

        // Imprimeix el mapa
        System.out.println(map);

        // Treu el conjunt de claus del mapa (variable kset)
        Set<String> kset = map.keySet();

        // Imprimeix aquest conjunt
        System.out.println(kset);

        // Treu el valor de la clau "PEUGEOT" i imprimeix-ho
        System.out.println();
        System.out.println(map.get("PEUGEOT"));

        // Mitjançant un iterador, imprimeix tots els parells clau-valor del mapa
        System.out.println();
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            String s = it.next();
            System.out.println(s + " - " + map.get(s));
        }

        // Empra un mapa que associi un caràcter a un número enter per dur el compte
        // de quantes vegades surt cada lletra a la paraula "ESTERNOCLEIDOMASTOIDEO"
        Map<Character, Integer> map2 = new HashMap<>();
        String s = "ESTERNOCLEIDOMASTOIDEO";

        for (char c : s.toCharArray()) {
            int i = 1;
            if (map2.get(c) != null) {
                i = map2.get(c) + 1;
            }

            map2.put(c, i);
        }

        System.out.println(map2);
    }
}

