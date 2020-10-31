if(delNode.rightLink == successor)
			    {
			    	//parent of delNode is foundNode[0]
			    	delNodeParent.rightLink = successor;
			    	successor.leftLink = delNode.leftLink;
			    }
			    else //meaning we traveled in the left descendant way.
			    {
			    	//successor cannot have a left child.
			    	if(successor.rightLink != null)
			    	{	
			    		successorParent.leftLink = successor.rightLink;
			    		successor.rightLink = delNode.rightLink;
			    	}
			    	
			    	delNodeParent.rightLink = successor;
			    	successor.leftLink = delNode.leftLink;
			    }


			    delNode.nData = successor.nData;// data replaced
			    if(successor.rightLink!=null) //successor's right child is relocated
			    {
			    	if(isLeft(parentSuccessor))
			    		successorParent.leftLink = successor.rightLink;
			    }
			    
			    /*
			    if(isLeft(parentSuccessor))//disconnect successor from its parent
			    	successorParent.leftLink = null;
			    else if (isRight(parentSuccessor))
			    	successorParent.rightLink = null;
			    */
			    successor = null;