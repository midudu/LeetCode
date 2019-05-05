import "container/list"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func levelOrder(root *TreeNode) [][]int {

	var result [][]int

	if root == nil {
		return result
	}

	var queue = list.New()
	queue.PushBack(root)

	for queue.Len() != 0 {

		var currentResult []int

		currentSize := queue.Len()

		for i := 0; i < currentSize; i++ {

			var currentNode = (queue.Front().Value).(*TreeNode)

			if currentNode.Left != nil {
				queue.PushBack(currentNode.Left)
			}
			if currentNode.Right != nil {
				queue.PushBack(currentNode.Right)
			}

			currentResult = append(currentResult, currentNode.Val)
			queue.Remove(queue.Front())
		}

		result = append(result, currentResult)
	}

	return result
}
