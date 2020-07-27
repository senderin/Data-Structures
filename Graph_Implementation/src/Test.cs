using System;
namespace Graph_Implementation
{
    public class Test
    {
        static void Main(string[] args)
        {
            string filePath = "TestFile.txt";
            File file = new File(filePath, false);
            Graph graph = new Graph(GraphType.DIRECTED, DistanceType.UNWEIGHTED);
            graph.CreateGraphFromFile(file, ',');

            graph.WriteNodes();
            graph.WriteEdges();
        }
    }
}
