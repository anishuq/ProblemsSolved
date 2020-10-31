

if(head == null)
		{
			newNode = new Node(val); 
			head = tail = newNode;
			//first element, so both tail and head are same.
		}
		else
		{
			newNode = new Node(val);
			tail.next = newNode;
			tail = tail.next;
			//reference has to move further down.
		}
		return head;



Node(int i)
	{
		this(i,null);
	}

	Node traveseNode = head;
		Node newNode = null;
		
		while(traveseNode!=null)
		{
			if(traveseNode.info == pos) 
			{
			    //if its the head.
				if(head.info == traveseNode.info)
				{
					newNode = new Node(value);
					newNode.next = head;
					head = newNode;
				}
				//if its the tail.
				else if(traveseNode.next == null)
				{
					newNode = new Node(value);
					traveseNode.next = newNode;
				}
				else //any where in the middle.
				{
					newNode = new Node(value);
					newNode.next = traveseNode.next;
					traveseNode.next = newNode;
				}
				break;
			}	
			traveseNode = traveseNode.next;
		}
		return head;



System.out.println("Input Data for LinkedList: enter -1 for exit");
		while(true)
		{
			value = inputData.nextInt();
			if(value == -1) break; 
			else headNode = lnListBuild.LinkedLListBuild(value);
		}
		
		lnListBuild.printAll(headNode);
		
		System.out.println("Inserting: input data to find position");
		int pos = inputData.nextInt();
		
		System.out.println("Value to insert");
		value = inputData.nextInt();
		
		headNode = lnListBuild.insertNode(headNode, pos, value);
		lnListBuild.printAll(headNode);




	if(head == null || head.info > val)
		{	
			p = new Node(val,null);
			p.next = head;
			head = p;
		}
		else
		{
			p = head;
			//find position
			while(p.next.info > val)
			{
				
			}
		}