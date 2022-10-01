package seedu.address.model;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

/**
 * Representation of a module, taught by a prof.
 */
public class Module {
    private String name;
    public Module(String moduleName) {
        requireAllNonNull(moduleName);
        this.name = moduleName;
    }

    public String toString() {
        return name;
    }
}
