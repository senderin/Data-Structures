using System;
using System.Collections.Generic;

namespace Graph_Implementation
{
    public class Node
    {
        public string name;
        private List<Edge> connections;

        public Node(string name)
        {
            this.name = name;
            connections = new List<Edge>();
        }

        public void AddConnection(Edge edge) {
            connections.Add(edge);
        }

        public List<Edge> GetConnections() {
            return connections;
        }
    }
}
