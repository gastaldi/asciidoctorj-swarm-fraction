/*
 * Copyright 2017 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.wildfly.swarm.asciidoctorj.detect;

import org.wildfly.swarm.spi.meta.PackageFractionDetector;

/**
 *
 * @author <a href="mailto:ggastald@redhat.com">George Gastaldi</a>
 */
public class AsciidoctorJDetector extends PackageFractionDetector {

    public AsciidoctorJDetector() {
        anyPackageOf("org.asciidoctor");
    }

    @Override
    public String artifactId() {
        return "asciidoctorj";
    }

}
