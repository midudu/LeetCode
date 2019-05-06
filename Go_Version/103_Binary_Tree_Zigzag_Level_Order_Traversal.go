package leetcode

import "container/list"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func zigzagLevelOrder(root *TreeNode) [][]int {

	var result [][]int
	if root == nil {
		return result
	}

	queue := list.New()
	queue.PushBack(root)

	var ifOddLayer = true

	for queue.Len() != 0 {

		var currentResult []int
		var size = queue.Len()

		for i := 0; i < size; i++ {

			var currentNode = queue.Front().Value.(*TreeNode)
			queue.Remove(queue.Front())

			if currentNode.Left != nil {
				queue.PushBack(currentNode.Left)
			}
			if currentNode.Right != nil {
				queue.PushBack(currentNode.Right)
			}

			currentResult = append(currentResult, currentNode.Val)
		}

		if ifOddLayer == true {
			result = append(result, currentResult)
		} else {
			var currentResultCopy []int
			for i := 0; i < len(currentResult); i++ {
				currentResultCopy = append(currentResultCopy, currentResult[len(currentResult)-1-i])
			}
			result = append(result, currentResultCopy)
		}

		ifOddLayer = !ifOddLayer
	}

	return result
}
