package com.liferay.upgrades.analyzer.exporter;

import com.liferay.upgrades.analyzer.project.dependency.exporter.CsvProjectDependencyExporter;
import com.liferay.upgrades.analyzer.project.dependency.graph.builder.ProjectsDependencyGraph;
import com.liferay.upgrades.analyzer.project.dependency.graph.builder.ProjectsDependencyGraphBuilder;
import com.liferay.upgrades.analyzer.project.dependency.model.Project;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.File;
import java.util.Set;

public class CsvProjectDependencyExporterTest {

    @Test
    public void testExportCsv(){
        final var expectedMessage = "CSV file generated at ";

        CsvProjectDependencyExporter mockCsvProjectDependencyExporter = Mockito.mock(CsvProjectDependencyExporter.class);

        ProjectsDependencyGraph mockProjectsDependencyGraph = Mockito.mock(ProjectsDependencyGraph.class);

        Mockito.when(
                mockCsvProjectDependencyExporter.export(mockProjectsDependencyGraph)
                )
                .thenReturn(
                        "CSV file generated at projects-" + System.currentTimeMillis() + ".csv"
                );

        final var actualMessage = mockCsvProjectDependencyExporter.export(mockProjectsDependencyGraph);

        Assertions.assertTrue(actualMessage.contains("CSV file generated at "), expectedMessage);
    }
}
