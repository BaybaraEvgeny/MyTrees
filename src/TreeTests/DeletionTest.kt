import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

internal class DeletionTest {
    private fun createTree(): RedBlackTree<Int, Int> {

        val tree = RedBlackTree<Int, Int>()

        val root = RBNode(27, 27)
        root.color = false

        val node1 = RBNode(35, 35)
        root.right = node1
        node1.parent = root

        val node2 = RBNode(30, 30)
        node1.left = node2
        node2.parent = node1
        node2.color = false

        val node3 = RBNode(40, 40)
        node1.right = node3
        node3.parent = node1
        node3.color = false

        val node4 = RBNode(28, 28)
        node2.left = node4
        node4.parent = node2

        val node5 = RBNode(25, 25)
        root.left = node5
        node5.parent = root

        val node6 = RBNode(26, 26)
        node5.right = node6
        node6.parent = node5
        node6.color = false

        val node7 = RBNode(15, 15)
        node5.left = node7
        node7.parent = node5
        node7.color = false

        val node8 = RBNode(20, 20)
        node7.right = node8
        node8.parent = node7

        val node9 = RBNode(10, 10)
        node7.left = node9
        node9.parent = node7

        tree.root = root

        return tree

    }

    @Test
    fun deleteFromEmptyTree() {

        val expectedTree = RedBlackTree<Int, Int>()
        val actualTree = RedBlackTree<Int, Int>()

        actualTree.delete(20)

        assertEquals(expectedTree, actualTree)

    }

    @Test
    fun deleteNonExistentKey() {

        val expectedTree = createTree()

        val actualTree = RedBlackTree<Int, Int>()

        for (i in listOf(20, 25, 30, 40, 35, 27, 26, 10, 15, 28)) {
            actualTree.insert(i, i)
        }

        for (i in listOf(21, 22, 31, 32, 41, 42)) {
            actualTree.delete(i)
        }

        assertEquals(expectedTree, actualTree)

    }

    @Test
    fun deleteIllegalKey() {

        val expectedTree = createTree()

        val actualTree = RedBlackTree<Int, Int>()

        for (i in listOf(20, 25, 30, 40, 35, 27, 26, 10, 15, 28, null)) {
            actualTree.insert(i, i)
        }

        actualTree.delete(null)

        assertEquals(expectedTree, actualTree)

    }

    @Test
    fun deleteRootLeaf() {

        val expectedTree = RedBlackTree<Int, Int>()

        val actualTree = RedBlackTree<Int, Int>()

        actualTree.insert(25, 25)

        actualTree.delete(25)

        assertEquals(expectedTree, actualTree)
    }

    /** Simple == deletion root with two red children
     * */
    @Test
    fun deleteRootNonLeafSimple() {

        val expectedTree = RedBlackTree<Int, Int>()

        val root = RBNode(30, 30)
        root.color = false

        val node1 = RBNode(20, 20)
        root.left = node1
        node1.parent = root

        expectedTree.root = root

        val actualTree = RedBlackTree<Int, Int>()

        for (i in listOf(20, 25, 30)) {
            actualTree.insert(i, i)
        }

        actualTree.delete(25)

        assertEquals(expectedTree, actualTree)
    }

    @Test
    fun deletecase(){//N is new root
        var expectedTree = RedBlackTree<Int,Int>()
        var actualTree = RedBlackTree<Int,Int>()
        expectedTree.root = RBNode(6,6)
        expectedTree.root!!.color = false
        actualTree.insert(3,3)
        actualTree.insert(6,6)
        actualTree.delete(3)
        assertEquals(expectedTree,actualTree)
    }

    @Test
    fun deleteRightRedLeaf() {

        val expectedTree = RedBlackTree<Int, Int>()

        val root = RBNode(25, 25)
        root.color = false

        val node1 = RBNode(20, 20)
        root.left = node1
        node1.parent = root

        expectedTree.root = root

        val actualTree = RedBlackTree<Int, Int>()

        for (i in listOf(25, 20, 30)) {
            actualTree.insert(i, i)
        }

        actualTree.delete(30)

        assertEquals(expectedTree, actualTree)
    }

    //  Case1 == next smaller/bigger node is red leaf
    @Test
    fun deleteInternalNodeCase1() {

        val expectedTree = RedBlackTree<Int, Int>()

        val root = RBNode(25, 25)
        root.color = false

        val node1 = RBNode(20, 20)
        root.left = node1
        node1.parent = root
        node1.color = false

        val node2 = RBNode(40, 40)
        root.right = node2
        node2.parent = root
        node2.color = false

        val node3 = RBNode(27, 27)
        node2.left = node3
        node3.parent = node2

        expectedTree.root = root

        val actualTree = RedBlackTree<Int, Int>()

        for (i in listOf(25, 20, 30, 40, 27)) {
            actualTree.insert(i, i)
        }

        actualTree.delete(30)

        assertEquals(expectedTree, actualTree)
    }

    // Case2 == Black node with one left red child
    @Test
    fun deleteInternalNodeCase2() {

        val expectedTree = RedBlackTree<Int, Int>()

        val root = RBNode(25, 25)
        root.color = false

        val node1 = RBNode(20, 20)
        root.left = node1
        node1.parent = root
        node1.color = false

        val node2 = RBNode(27, 27)
        root.right = node2
        node2.parent = root
        node2.color = false

        expectedTree.root = root

        val actualTree = RedBlackTree<Int, Int>()

        for (i in listOf(25, 20, 30, 27)) {
            actualTree.insert(i, i)
        }

        actualTree.delete(30)

        assertEquals(expectedTree, actualTree)
    }

    // Case3 == Black node with one right red child
    @Test
    fun deleteInternalNodeCase3() {

        val expectedTree = RedBlackTree<Int, Int>()

        val root = RBNode(25, 25)
        root.color = false

        val node1 = RBNode(20, 20)
        root.left = node1
        node1.parent = root
        node1.color = false

        val node2 = RBNode(40, 40)
        root.right = node2
        node2.parent = root
        node2.color = false

        expectedTree.root = root

        val actualTree = RedBlackTree<Int, Int>()

        for (i in listOf(25, 20, 30, 40)) {
            actualTree.insert(i, i)
        }

        actualTree.delete(30)

        assertEquals(expectedTree, actualTree)
    }




}