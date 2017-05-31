import org.junit.jupiter.api.Test
import java.util.*

/*  1 million
   Insert RBTree - 15s
   Insert RBTree Random - 16s 352ms
   Insert Btree - 16s 426ms
   Insert BtreeRandom - 18s 746ms
   Search RBTree - 16ms
   Search RBTreeRandom - 15ms
   Search BTree - 63ms
   Search BTreeRandom - 69ms
 */


internal class StressTest {
    val RBTtree = RedBlackTree<Int, Int>()

    @Test
    fun insertRBT() {



        for (i in 1..1000000) {
            println(i)
            RBTtree.insert(i, i)
        }

    }
    @Test fun searchRBT() {
        for (i in 1..1000000) {
            RBTtree.search(i)
        }
    }

    val Btree = BTree<Int, Int>(100)
    @Test //t = 100
    fun insertBT() {


        for (i in 1..1000000) {
            println(i)
            Btree.insert(i, i)
        }

    }
    @Test fun searchBT() {
        for (i in 1..1000000) {
            Btree.search(i)
        }
    }

    val RBTtreeRandom = RedBlackTree<Int, Int>()
    @Test fun insertRBTRandom() {

            for (i in 1..1000000) {
                println(i)

                val k = Random().nextInt(1000000)
                RBTtreeRandom.insert(k, k)
        }

    }
    @Test fun searchRBTRandom() {
        for (i in 1..1000000) {
            RBTtreeRandom.search(i)
        }
    }

    val BtreeRandom = BTree<Int, Int>(100)
    @Test fun insertBTRandom() {
        for (i in 1..1000000) {
            println(i)
            val k = Random().nextInt(1000000)
            BtreeRandom.insert(k,k)
        }

    }

    @Test fun searchBTRandom() {
        for (i in 1..1000000) {
            BtreeRandom.search(i)
        }
    }



}
