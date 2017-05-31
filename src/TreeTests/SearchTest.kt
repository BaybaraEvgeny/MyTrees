import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*


internal class SearchTest {

    @Test
    fun searchByIllegalKey() {
        val tree = RedBlackTree<Int, Int>()

        assertNull(tree.search(null))

    }

    @Test
    fun searchInEmptyTree() {

        val tree = RedBlackTree<Int, Int>()

        for (i in 1..10) {
            assertNull(tree.search(i))
        }
    }

    @Test
    fun searchNonExistentValue() {

        val tree = RedBlackTree<Int, Int>()
        for (i in 1..100) {
            tree.insert(i, 2*i)
        }

        for (i in 1..100) {
            assertNotEquals(i, tree.search(i))
        }

    }

    @Test
    fun searchNonExistentKey() {

        val tree = RedBlackTree<Int, Int>()
        for (i in 1..100) {
            tree.insert(i, 2*i)
        }

        for (i in 101..200) {
            assertNull(tree.search(i))
        }

    }

    @Test
    fun search() {

        val tree = RedBlackTree<Int, Int>()
        for (i in 1..100) {
            tree.insert(i, 2*i)
        }

        for (i in 100 downTo 1) {
            assertEquals(i*2, tree.search(i))
        }
    }

}