// App.js

import React from 'react';
import AboutMe from './AboutMe';
import Contact from './Contact';
import MenuItems from './MenuItems';
import MyProjects from './MyProjects';

import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';

const projects = require('../../../../../resources/projects.json');

const tags = Object.keys(
	projects
		.map(({ tags = [] }) => tags)
		.reduce((tagMap, tags) => {
			tags.forEach(tag => {
				tagMap[tag] = true;
			});
			return tagMap;
		}, {})
).sort();

const resumeURL = 'resources/resume.pdf';

const App = () => {
	return (
		<Router>
			<div className="App">
				<div className="App-content">
					<div className="App-menu">
						<div className="menu">
							<Route path="/:id*" component={MenuItems} />
						</div>
					</div>
					<Route
						path="/"
						exact
						component={() => (
							<div className="App-aboutMe">
								<AboutMe />
							</div>
						)}
					/>
					<Switch>
						<Route
							path="/projects"
							component={() => (
								<div className="App-projects">
									<MyProjects
										tags={tags}
										projects={projects}
									/>
								</div>
							)}
						/>
						<Route
							path="/contact"
							component={() => (
								<div className="App-contact">
									<Contact />
								</div>
							)}
						/>
						<Route
							component={() => (
								<div className="App-aboutMe">
									<AboutMe resumeURL={resumeURL} />
								</div>
							)}
						/>
					</Switch>
				</div>
			</div>
		</Router>
	);
};

export default App;
