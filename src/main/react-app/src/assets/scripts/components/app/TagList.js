// TagList.js;

import React from 'react';
import PropTypes from 'prop-types';

const TagList = ({
	className = '',
	tags = [],
	selectedTags = [],
	onSelectedTagsChange
}) => {
	const handleTagClick = tag => {
		var newSelectedTags;
		if (selectedTags.includes(tag)) {
			newSelectedTags = selectedTags.filter(
				selectedTag => selectedTag !== tag
			);
		} else {
			selectedTags.push(tag);
			newSelectedTags = selectedTags;
		}
		onSelectedTagsChange(newSelectedTags);
	};

	return (
		<div className={`TagList ${className}`}>
			{tags.map(
				tag =>
					tag &&
					tag !== '*' && (
						<Tag
							key={'tag-' + tag}
							tag={tag}
							selected={selectedTags.includes(tag)}
							onClick={handleTagClick}
							className="user-select-disabled"
						/>
					)
			)}
		</div>
	);
};

TagList.displayName = 'TagList';

TagList.propTypes = {
	className: PropTypes.string,
	tags: PropTypes.array,
	selectedTags: PropTypes.array,
	onSelectedTagsChange: PropTypes.func
};

const Tag = ({ className = '', tag, selected = false, onClick }) => {
	const handleClick = () => {
		onClick(tag);
	};
	return (
		<a
			className={`Tag ${className} ${selected ? 'Tag-selected' : ''}`}
			onClick={handleClick}
		>
			{tag}
		</a>
	);
};

Tag.displayName = 'Tag';

Tag.propTypes = {
	className: PropTypes.string,
	tag: PropTypes.string,
	onClick: PropTypes.func,
	selected: PropTypes.bool
};

export default TagList;
