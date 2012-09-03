package org.hibernate.metamodel.internal.source.annotations;

import java.util.List;

import org.hibernate.metamodel.internal.source.annotations.attribute.PluralAssociationAttribute;
import org.hibernate.metamodel.spi.binding.PluralAttributeIndexBinding;
import org.hibernate.metamodel.spi.source.ExplicitHibernateTypeSource;
import org.hibernate.metamodel.spi.source.PluralAttributeIndexSource;
import org.hibernate.metamodel.spi.source.RelationalValueSource;

/**
 * @author Strong Liu <stliu@hibernate.org>
 */
public class PluralAttributeIndexSourceImpl implements PluralAttributeIndexSource {
	private final PluralAssociationAttribute attribute;
	private final IndexedPluralAttributeSourceImpl indexedPluralAttributeSource;

	public PluralAttributeIndexSourceImpl(IndexedPluralAttributeSourceImpl indexedPluralAttributeSource, PluralAssociationAttribute attribute) {
		this.attribute = attribute;
		this.indexedPluralAttributeSource = indexedPluralAttributeSource;
	}

	@Override
	public PluralAttributeIndexBinding.Nature getNature() {
		switch ( indexedPluralAttributeSource.getElementSource().getNature() ){
			case BASIC:
				return PluralAttributeIndexBinding.Nature.BASIC;
			case COMPONENT:
				return PluralAttributeIndexBinding.Nature.COMPOSITE;
			case MANY_TO_ANY:
				return PluralAttributeIndexBinding.Nature.MANY_TO_ANY;
			case MANY_TO_MANY:
				return PluralAttributeIndexBinding.Nature.MANY_TO_MANY;
		}
		return null;
	}

	@Override
	public int base() {
		return 0;
	}

	@Override
	public ExplicitHibernateTypeSource explicitHibernateTypeSource() {
		return null;
	}

	@Override
	public List<RelationalValueSource> relationalValueSources() {
		return null;
	}

	@Override
	public boolean areValuesIncludedInInsertByDefault() {
		return false;
	}

	@Override
	public boolean areValuesIncludedInUpdateByDefault() {
		return false;
	}

	@Override
	public boolean areValuesNullableByDefault() {
		return false;
	}
}
